package com.shu.message.service;

import com.shu.message.dao.CommentMapper;
import com.shu.message.model.entity.Comment;
import com.shu.message.model.entity.CommentExample;
import com.shu.message.model.ov.Result;
import com.shu.message.model.ov.resultsetting.*;
import com.shu.message.tools.ResultTool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: message
 * @description:
 * @author: ggmr
 * @create: 2018-08-28 20:06
 */
@Service
public class CommentService {
    @Resource
    private UserService userService;

    @Resource
    private CommentMapper commentMapper;

    private static final int COMMENT_TYPE = 2;

    private static final String HOT_COMMENT = "热门评论";
    private static final String NEW_COMMENT = "最新评论";

    /**
     * @Description: 根据给定信息返回评论列表
     * @Param: [type, id, page, limit]
     * @Return: com.shu.message.model.ov.Result
     * @Author: ggmr
     * @Date: 18-8-28
     */
    public Result getCommentList(int type, int msgId, int page, List<Integer> limit) {
        CommentExample example = new CommentExample();
        example.createCriteria()
                .andTypeEqualTo(type)
                .andIdEqualTo(msgId);
        List<Comment> list = commentMapper.selectByExample(example);
        if(list.isEmpty()) {
            return ResultTool.error("没有评论");
        }
        List<CommentListResponseInfo> commentListResponseInfoList = new LinkedList<>();
        //hot评论
        if(page > 0) {
            commentListResponseInfoList.add(new CommentListResponseInfo("热门评论"));
        } else {
            //热评根据点赞数排序
            list.sort((Comment o1, Comment o2) -> (o2.getLikeNum().compareTo(o1.getLikeNum())));
            commentListResponseInfoList.add(setComment(HOT_COMMENT, list, limit.get(0), page));
        }
        //最新评论根据时间排序
        list.sort((Comment o1, Comment o2) -> (o2.getCreateTime().compareTo(o1.getCreateTime())));
        commentListResponseInfoList.add(setComment(NEW_COMMENT, list, limit.get(1), page));
        //最新评论
        return ResultTool.success(new CommentListResponse(commentListResponseInfoList));
    }

    /**
     * @Description: 填写CommentListResponseInfo内容
     * @Param: [blockName, list, limitNum]
     * @Return: com.shu.message.model.ov.resultsetting.CommentListResponseInfo
     * @Author: ggmr
     * @Date: 18-8-28
     */
    private CommentListResponseInfo setComment(String blockName, List<Comment> list, int limitNum, int page) {
        List<CommentInfo> cards = new LinkedList<>();
        //便利所有的给定的排序后的评论
        for(int count = 0;count < limitNum; count++) {
            Comment comment;
            if(blockName.equals(HOT_COMMENT)) {
                comment = list.get(count);
            } else {
                comment = list.get(page * limitNum + count);
            }
            CommentInfo commentInfo = new CommentInfo();
            commentInfo.setAuthor(userService.getUserInfoById(comment.getUserId()));
            commentInfo.setContent(comment.getContent());
            commentInfo.setInfo(comment.getType(), comment.getCommentId());
            commentInfo.setLike(comment.getLikeNum());
            commentInfo.setPhotos(comment.getImgUrl());
            commentInfo.setPublishTime(comment.getCreateTime());
            //该评论的回复内容
            ReplyInfo replyInfo = new ReplyInfo();
            Comment reply = commentMapper.selectByPrimaryKey(comment.getCommentId());
            replyInfo.setCount(reply.getCommentNum());
            if(reply.getCommentNum() == 0) {
                cards.add(commentInfo);
                continue;
            }
            //根据这个回复内容的id找到他的所有的回复
            CommentExample commentReplyExample = new CommentExample();
            commentReplyExample.createCriteria()
                    .andTypeEqualTo(COMMENT_TYPE)
                    .andIdEqualTo(reply.getCommentId());
            List<Comment> commentReplyList = commentMapper.selectByExample(commentReplyExample);
            commentReplyList.sort((Comment o1, Comment o2) -> (o2.getLikeNum().compareTo(o1.getLikeNum())));
            int replyNum = 0;
            //便利这个回复的所有的子回复，并且最多显示2个
            List<RepresentativesInfo> representativesInfoList = new LinkedList<>();
            for(Comment commentReply : commentReplyList) {
                if(replyNum == 2) { break; }
                RepresentativesInfo representativesInfo = new RepresentativesInfo();
                representativesInfo.setAuthor(commentReply.getUserId(),
                            userService.getUserNameById(commentReply.getUserId()));
                representativesInfo.setContent(commentReply.getContent());
                representativesInfo.setPhotos(commentReply.getImgUrl());
                representativesInfoList.add(representativesInfo);
                replyNum++;
            }
            replyInfo.setRepresentatives(representativesInfoList);

            commentInfo.setReplies(replyInfo);
            cards.add(commentInfo);
        }
        return new CommentListResponseInfo(blockName, cards);
    }

    /**
     * @Description: 该api对新闻、动态进行评论，或者对评论进行回复，或者对回复进行回复
     * @Param: [type,id,content,img]
     * @Return: com.shu.message.model.ov.Result
     * @Author: xw
     * @Date: 18-8-29
     */
    public Result insertComment(String userId, CommentRequest commentRequest){

        Result result = new Result();
        try {
            Comment comment = new Comment();
            comment.setType(commentRequest.getType());
            comment.setId(commentRequest.getId());
            comment.setUserId(userId);
            comment.setContent(commentRequest.getContent());
            comment.setImgUrl(commentRequest.getImg());
            if(commentRequest.getReplyId() != null){
                comment.setReplayId(commentRequest.getReplyId());
                Comment comment1 = commentMapper.selectByPrimaryKey(commentRequest.getReplyId());
                comment.setReplayUserId(comment1.getUserId());
                commentMapper.insertSelective(comment);
            }else{
                comment.setReplayId(null);
                comment.setReplayUserId(null);
                commentMapper.insertSelective(comment);
            }
            result = ResultTool.success();
        }catch (Exception e){
            result = ResultTool.error("评论失败！");
        }

        return result;
    }

}
