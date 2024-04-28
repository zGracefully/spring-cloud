package com.example.common.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
public class LogAspest {
    @Autowired
    private HttpServletRequest request;
    @Pointcut("@annotation(com.example.common.config.LogAnnotation)")
    public void LogCut(){}

    @Around("LogCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("进入环绕通知..." + request.getHeader("token"));
        return proceedingJoinPoint.proceed();
    }
}
