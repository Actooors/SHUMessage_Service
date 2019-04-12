package com.shumsg.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
/**
 * @program: shumsg
 * @description: token工具
 * @author: 0GGmr0
 * @create: 2019-04-11 10:37
 */
public class jwtUtil {
    private final static byte[] ENCODE_KEY = "message".getBytes();
    private static JWTVerifier jwtVerifier;

    public static String createJwt(String subject, String nickname) {
        Date currentDate = new Date();
        // 过期时间5天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 36500);
        Algorithm algorithm = Algorithm.HMAC256(ENCODE_KEY);
        return JWT.create()
                .withIssuedAt(currentDate)
                .withExpiresAt(calendar.getTime())
                .withSubject(subject)
                .withClaim("nickname", nickname == null ? "" : encode(nickname))
                .sign(algorithm);
    }

    public static String parseJwt(String jwt) throws JWTVerificationException {
        Algorithm algorithm  = Algorithm.HMAC256(ENCODE_KEY);
        if (jwtVerifier == null){
            jwtVerifier = JWT.require(algorithm).build();
        }
        jwtVerifier.verify(jwt);
        return JWT.decode(jwt).getSubject();
    }

    private static String encode(String url)
    {
        try {
            return URLEncoder.encode( url, "UTF-8" );
        } catch (UnsupportedEncodingException e) {
            return "Issue while encoding" +e.getMessage();

        }

    }

}
