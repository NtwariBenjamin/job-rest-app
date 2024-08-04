package com.benjamin.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.benjamin.springbootrest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint joinPoint){
        LOGGER.info("Method Called "+joinPoint.getSignature().getName());
    }
    @After("execution(* com.benjamin.springbootrest.service.JobService.*(..))")
    public void logMethodExecuted(JoinPoint joinPoint){
        LOGGER.info("Method Executed  "+joinPoint.getSignature().getName());
    }
    @AfterThrowing("execution(* com.benjamin.springbootrest.service.JobService.*(..))")
    public void logMethodCrash(JoinPoint joinPoint){
        LOGGER.info("Method Has some issues "+joinPoint.getSignature().getName());
    }
    @AfterReturning("execution(* com.benjamin.springbootrest.service.JobService.*(..))")
    public void logMethodExecutedSuccess(JoinPoint joinPoint){
        LOGGER.info("Method Has Executed Successfully "+joinPoint.getSignature().getName());
    }
}
