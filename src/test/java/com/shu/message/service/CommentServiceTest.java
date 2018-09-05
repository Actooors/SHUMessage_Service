package com.shu.message.service;

import com.shu.message.model.ov.resultsetting.CommentRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CommentServiceTest {

    @Resource
    private CommentService commentService;

    @Test
    public void insertComment() {
        CommentRequest commentRequest = new CommentRequest();
        commentRequest.setType(0);
        commentRequest.setId(2);
        //commentRequest.setReplyId(12);
        commentRequest.setContent("良神郭神轩神唐神！");
        commentService.insertComment("16121666",commentRequest);
        //System.out.print(commentRequest.getReplyId());
    }
}