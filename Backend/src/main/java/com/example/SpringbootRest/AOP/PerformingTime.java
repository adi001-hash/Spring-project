package com.example.SpringbootRest.AOP;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformingTime {


    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Around("execution(* com.example.SpringbootRest.service.jobservice.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {

        long start = System.currentTimeMillis();
        Object obj = jp.proceed();
        long end = System.currentTimeMillis();

        LOGGER.info("Time Taken : " + (start-end) + "ms");

        return obj;
    }
}
