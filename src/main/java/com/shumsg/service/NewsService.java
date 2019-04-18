package com.shumsg.service;

import com.shumsg.dao.NewsMapper;
import com.shumsg.exception.AllException;
import com.shumsg.model.back.Result;
import com.shumsg.model.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: shumsg
 * @description:
 * @author: 0GGmr0
 * @create: 2019-04-10 18:20
 */
@Service
public class NewsService {
    @Resource
    private NewsMapper newsMapper;



    /**
     * @Description: 获取新闻列表，按照时间排序
     * @Param: []
     * @Return: com.shumsg.model.back.Result
     * @Author: 0GGmr0
     * @Date: 2019-04-10
     */
    public Result getNewsList(Integer page, Integer pageSize, Integer usersId) throws AllException {
        User user = new User();

//        List<UserNewsInfo> newsList;
//        try {
//            // 第一个参数(page - 1) * pageSize 表示的是从排好序的哪条数据开始取
//            // 第二个参数表示现在一页有多少数据
//            newsList = newsMapper.selectNewsList((page - 1) * pageSize, pageSize, usersId);
//        } catch (Exception e) {
//            log.info("查询新闻列表报错，错误信息为 " + e.toString());
//            throw new AllException(EmAllException.SELECT_ERROR);
//        }
//
//        List<NewsResponseInfo> resList = new LinkedList<>();
//        for(UserNewsInfo news : newsList) {
//            NewsResponseInfo res = new NewsResponseInfo();
//            res.setAuthor(new UserInfo(news.getUsersId(), news.getUserImg(),news.getUsername()));
//            // type id
//            res.setInfo(new Info(0, news.getNewsId()));
//            res.setPublishTime(news.getCreateTime());
//            // TODO 这里需要和label表交互，等待数据分析的结果
//            res.setTopic(new Topic(1, "资源动态"));
//            // like comment share
//            res.setShareInfo(new ShareInfo(news.getLikeNum(), news.getCommentNum(), news.getShareNum()));
//            // TODO 这个似乎是写死的，这个的确是写死的
//            res.setExtraInfo("官方新闻");
//            //依次是点赞，评论，转发
//            res.setFootprint(new Footprint(
//                    news.getLiked() == null ? false : news.getLiked(),
//                    news.getCommented() == null ? false : news.getCommented(),
//                    news.getShared() == null ? false : news.getShared()));
//            res.setContent(news.getNewsName());
//
//            int newsType = news.getType();
//            if(newsType == 1) {
//                res.setMedia(new Media(newsType, news.getNewsName(), news.getNewsUrl()));
//            } else {
//                res.setMedia(new Media(newsType, news.getImgUrl()));
//            }
//            resList.add(res);
//        }
//        return resList;
        return null;
    }
}


//<select id="selectNewsList" resultMap="getNewsListMap" parameterType="map">
//        SELECT
//        tbl_news.news_id, tbl_news.news_name, tbl_news.users_id, tbl_news.news_url,
//        tbl_news.news_content, tbl_news.news_description, tbl_news.img_url,
//        tbl_news.type, tbl_news.comment_num, tbl_news.like_num,
//        tbl_news.share_num, tbl_news.create_time, tbl_news.delete_time,
//        liked, commented, shared, username, user_img
//        FROM tbl_news LEFT JOIN tbl_users ON tbl_news.users_id = tbl_users.users_id
//        LEFT JOIN tbl_discuss ON news_id = tbl_discuss.id
//        LEFT JOIN tbl_share ON news_id = tbl_share.id
//        LEFT JOIN tbl_like ON news_id = tbl_like.id
//        WHERE CASE WHEN tbl_discuss.id IS NOT NULL THEN tbl_discuss.users_id = #{usersId,jdbcType=INTEGER} ELSE TRUE END
//        AND CASE WHEN tbl_share.id IS NOT NULL THEN tbl_share.users_id = #{usersId,jdbcType=INTEGER} ELSE TRUE END
//        AND CASE WHEN tbl_like.id IS NOT NULL THEN tbl_like.users_id = #{usersId,jdbcType=INTEGER} ELSE TRUE END
//        ORDER BY tbl_news.create_time DESC
//        LIMIT #{num,jdbcType=INTEGER} OFFSET #{offset,jdbcType=INTEGER};
//</select>