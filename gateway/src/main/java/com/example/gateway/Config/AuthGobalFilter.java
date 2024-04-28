package com.example.gateway.Config;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.common.Util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Component
@RequiredArgsConstructor
public class AuthGobalFilter implements GlobalFilter, Ordered {
    private final PathConfig pathConfig;
    private final ParamConfig paramConfig;
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        String authtoken = JWTUtil.createToken(paramConfig.getSignature());
//        ServerWebExchange tokens = exchange.mutate().request(builder -> builder.header("token", authtoken)).build();
        String token = exchange.getRequest().getHeaders().getFirst("token");
        System.out.println(token);
        ServerHttpRequest request = exchange.getRequest();
        System.out.println(request.getPath());
        if (isExclude(request.getPath().toString())){
            System.out.println(request.getURI());
            return chain.filter(exchange);
        }
        if (token == null){
            System.out.println("fail");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        try {
            DecodedJWT verify = JWTUtil.verify(token,paramConfig.getSignature());
            System.out.println(verify.getClaim("username"));
        }catch (Exception e){
            e.printStackTrace();
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        return chain.filter(exchange);
    }

    private boolean isExclude(String string) {
        for (String excludePath : pathConfig.getExcludePaths()) {
            if (antPathMatcher.match(excludePath,string)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
