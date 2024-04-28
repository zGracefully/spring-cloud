package com.example.common.Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {

    public static String createToken(String signature){
        JWTCreator.Builder builder = JWT.create();
        String sign = builder.withClaim("username", "jubi")
                .sign(Algorithm.HMAC256(signature));
        return sign;
    }

    public static DecodedJWT verify(String token,String signature){
        JWTVerifier build = JWT.require(Algorithm.HMAC256(signature)).build();
        DecodedJWT verify = build.verify(token);
        return verify;
    }
}
