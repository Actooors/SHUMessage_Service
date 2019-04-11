package com.shumsg.tools;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @program: shumsg
 * @description: HS256加密
 * @author: 0GGmr0
 * @create: 2019-04-11 12:44
 */
public class HS256 {
    private final static char[] ALPHABET = {'a','b','c','d','e','f','g','h','i',
                                     'j','k','l','m','n','o','p','q','r',
                                     's','t','u','v','w','x','y','z'};

    public static String encryptionPassword(String password) {
        Random random = new Random();
        String uuid = NanoIdUtils.randomNanoId(random, ALPHABET, 20);
        return DigestUtils.sha256Hex(uuid + password);
    }
}
