package com.casic.util;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.casic.metadata.service.util.TokenDecrypt;
import com.casic.metadata.service.util.TokenEncrypt;

/**
 * 加密解密测试
 * @author lrj
 *
 */
public class TokenMainTest {

    public static void main(String[] args) {
        // 生成token
        TokenEncrypt te = new TokenEncrypt();
        String token = te.getToken(true, "zhangchao", "罗仁杰");

        // 打印token
        System.out.println("token: " + token);

        // 解密token
        TokenDecrypt td = new TokenDecrypt();
        DecodedJWT jwt = td.deToken(token);

        System.out.println("issuer: " + jwt.getIssuer());
        System.out.println("isVip:  " + jwt.getClaim("isVip").asBoolean());
        System.out.println("username: " + jwt.getClaim("username").asString());
        System.out.println("name:     " + jwt.getClaim("name").asString());
        System.out.println("过期时间：      " + jwt.getExpiresAt());

    }

}
