package com.shumsg.interceptor;

import com.shumsg.model.entity.User;

/**
 * @program: shumsg
 * @description: 线程级共享User
 * @author: 0GGmr0
 * @create: 2019-04-13 23:10
 */
public class UserContext implements AutoCloseable {

    private static final ThreadLocal<User> current = new ThreadLocal<>();

    public UserContext(User user) {current.set(user);}

    public static User getCurrentUser() {return current.get();}

    @Override
    public void close() {
        current.remove();
    }
}
