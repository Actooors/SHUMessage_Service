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


    public static String encryptionPassword(String password, String uuid) {

        return DigestUtils.sha256Hex(uuid + password);
    }
}
