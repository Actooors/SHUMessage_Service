package com.shumsg.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.shumsg.dao.UserMapper;
import com.shumsg.exception.AllException;
import com.shumsg.exception.EmAllException;
import com.shumsg.interceptor.UserContext;
import com.shumsg.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import static com.shumsg.model.UserConstRepository.*;

/**
 * @program: shumsg
 * @description: token工具
 * @author: 0GGmr0
 * @create: 2019-04-11 10:37
 */
@Slf4j
@Component
public class JwtUtil {
    private final static byte[] ENCODE_KEY = "message".getBytes();
    private final static String TOKEN_HEADER = "Bearer ";

    private static JWTVerifier jwtVerifier;

    @Resource
    private UserMapper userMapper;

    /**
     * @Description: 创建token
     * @Author: 0GGmr0
     * @Date: 2019-04-15
     */

    public String createJwt(String subject, String nickname) throws AllException {
        Date currentDate = new Date();
        // 过期时间5天
        Calendar calendar = Calendar.getInstance();
        if(nickname == null) {
            calendar.add(Calendar.MINUTE, TEMPORARY_TOKEN_VALIDITY_MINUTE);
            nickname = "";
        } else {
            calendar.add(Calendar.DATE, NORMAL_TOKEN_VALIDITY_DAY);
            nickname = encode(nickname);
        }

        Algorithm algorithm = Algorithm.HMAC256(ENCODE_KEY);
        return TOKEN_HEADER + JWT.create()
                .withIssuedAt(currentDate)
                .withExpiresAt(calendar.getTime())
                .withSubject(subject)
                .withClaim("nickname", nickname)
                .sign(algorithm);
    }

    /**
     * @Description: 验证token的有效性
     * @Author: 0GGmr0
     * @Date: 2019-04-15
     */
    public int validateToken(String token) throws UnsupportedEncodingException {
        // 除去 Bearer 开头
        token = token.substring(7);
        Algorithm algorithm  = Algorithm.HMAC256(ENCODE_KEY);
        if (jwtVerifier == null){
            // 创建校验器
            jwtVerifier = JWT.require(algorithm).build();
        }
        try {
            jwtVerifier.verify(token);
        } catch (SignatureVerificationException e) {
            // 签名内容失效
            log.info("token签名内容失效，报错信息为{}", e.toString());
            return SIGNATURE_VERIFICATION_EXCEPTION;
        } catch (TokenExpiredException e1) {
            // 时间失效
            log.info("token时间过期，报错信息为{}", e1.toString());
            return TOKEN_EXPIRED_EXCEPTION;
        } catch (JWTDecodeException e2) {
            log.info("token格式有误，报错信息为{}", e2.toString());
            return FAKE_TOKEN;
        }
        DecodedJWT decodedJWT = JWT.decode(token);
        String uuid = decodedJWT.getSubject();
        User user = userMapper.selectUserByUserInfo(uuid, SELECT_USER_BY_UUID);
        // 创建一个线程级的变量 专门存储user
        new UserContext(user);

        // 如果获取到的nickname为空，说明此用户目前是临时token
        String nickname = URLDecoder.decode(
                decodedJWT.getClaim("nickname").asString(), "UTF-8");
        if(nickname.equals("")) {
            // 如果nickname为空，说明是一个临时的token
            return TEMPORARY_TOKEN;
        } else if(nickname.equals(user.getNickname())) {
            // 如果nickname正常，说明是正确的token
            return NORMAL_TOKEN;
        } else {
            // 这是一个伪造的token
            return FAKE_TOKEN;
        }

    }


    private static String encode(String str) throws AllException {
        try {
            return URLEncoder.encode( str, "UTF-8" );
        } catch (UnsupportedEncodingException e) {
            log.info("Issue while encoding" +e.getMessage());
            throw new AllException(EmAllException.ENCODE_ERROR);

        }

    }

}
