package com.all.win.business.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

/**
 * @Description: AOP配置类
 * @Author: fakerCoder
 * @Date: 2018/7/5 17:55
 * @Version: 1.0.0
 */
@Aspect
@Configuration
public class AopConfig {

    @Pointcut("execution(* com.all.win.business.controller.*.*(..))")
    public void executeService() {
    }

    @Before("executeService()")
    public void before(JoinPoint joinPoint) throws JsonProcessingException {
        System.out.println("我是前置通知!!!");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        String kind = joinPoint.getKind();
        SourceLocation location = joinPoint.getSourceLocation();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        System.out.println(signature.getName());
        //AOP代理类的名字
        System.out.println(signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String, String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()) {
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter, request.getParameter(parameter));
        }
        String str = new ObjectMapper().writeValueAsString(parameterMap);
        if (obj.length > 0) {
            System.out.println("请求的参数信息为：" + str);

        }
    }

    @After("executeService()")
    public void after() {
        System.out.println("切面AOP之后执行");
    }

    @AfterReturning("executeService()")
    public void afterReturning() {
        System.out.println("切面AOPafterReturning后执行");
    }

    @AfterThrowing("executeService()")
    public void afterThrowing() {
        System.out.println("切面afterThrowing执行了");
    }

    @Around("executeService()")
    public Object around(ProceedingJoinPoint thisJoinPoint) {
        Object obj = null;
        System.err.println("切面around before执行了");
        try {
            thisJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.err.println("切面around after执行了");
        return obj;
    }
}
