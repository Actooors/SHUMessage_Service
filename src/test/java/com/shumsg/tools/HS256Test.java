package com.shumsg.tools;

import org.junit.Test;

import java.security.SecureRandom;
import java.util.UUID;

import static org.junit.Assert.*;

public class HS256Test {

    @Test
    public void encryptionPassword() {
//        java.security.SecureRandom
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
        String encryption = HS256.encryptionPassword("test");
        String ex = HS256.encryptionPassword("test");
        System.out.println(encryption.equals(ex));
        for(byte a : SecureRandom.getSeed(26)) {
            System.out.println(a);
        }
    }
}