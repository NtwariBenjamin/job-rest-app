package com.benjamin.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    private static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);
    @Around("execution(* com.benjamin.springbootrest.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start=System.currentTimeMillis();
        Object obj=joinPoint.proceed();
        long end=System.currentTimeMillis();

        LOGGER.info("Time Taken by "+joinPoint.getSignature().getName()+" : "+ (end-start)+"Ms");
        return obj;
    }
}