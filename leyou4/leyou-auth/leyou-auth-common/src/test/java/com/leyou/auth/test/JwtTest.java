package com.leyou.auth.test;

import org.junit.Before;
import org.junit.Test;
import pojo.UserInfo;
import utils.JwtUtils;
import utils.RsaUtils;

import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * @author HackerStar
 * @create 2020-07-03 09:27
 */
public class JwtTest {
    private static final String pubKeyPath = "/Users/XinxingWang/Desktop/md文档/Java开发/03_JavaEE/乐优商城/day17/secret/rsa.pub";

    private static final String priKeyPath = "/Users/XinxingWang/Desktop/md文档/Java开发/03_JavaEE/乐优商城/day17/secret/rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "234");
    }

    @Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(20L, "jack"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU5Mzc0MDc4NX0.PsW3LW4KE6p6T6Ueo-8nBlU-zYz5I_U8nDK490pxDf5vCC5TaratGXi-TwDJZAIxxxdVyqWTSA1LA5VCr6hN6Ua_Wb_R6V7e4g9XoV_21cRv1qih6U-GyZLb5BInQUCKhgjtLDerZrgCjT6aJ4zLkEF55jgmQLnYlaR_K7wmeZo";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}
