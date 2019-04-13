package com.shumsg.service;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void modifyUserInfo() {
        Date lastModifyNicknameTime = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(lastModifyNicknameTime);
        System.out.println(cal.get(Calendar.YEAR));
    }

}