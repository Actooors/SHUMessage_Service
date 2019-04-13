package com.shumsg.schedule;

import com.shumsg.dao.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

import static com.shumsg.model.UserConstRepository.EDITABLE_NICKNAME_TIMES;

/**
 * @program: shumsg
 * @description: 定义了所有需要定时执行的操作
 * @author: 0GGmr0
 * @create: 2019-04-12 20:57
 */
@Component
@Slf4j
public class ScheduledService {

    @Resource
    private UserMapper userMapper;

    /**
     * @Description: 在每年的一月一重置用户修改昵称的次数
     * @Author: 0GGmr0
     * @Date: 2019-04-12
     */
    @Scheduled(cron = "0 0 0 1 1 *")
    public void refreshUserNicknameModifyTimes(){
        try {
            userMapper.updateEditableNicknameTimes(EDITABLE_NICKNAME_TIMES);
        } catch (Exception e) {
            log.info("执行cron更新用户昵称可修改次数出错，出错原因为{}", e.toString());
        }
        log.info("=========>>>>>>使用 cron 更新了用户昵称可修改次数");
    }


//    @Scheduled(cron = "0/2 * * * * *")
//    public void test() {
//        try {
//            userMapper.updateEditableNicknameTimes(EDITABLE_NICKNAME_TIMES);
//        } catch (Exception e) {
//            log.info("执行cron更新用户昵称可修改次数出错，出错原因为{}", e.toString());
//        }
//        log.info("=========>>>>>>使用 cron 更新了用户昵称可修改次数");
//    }
}
