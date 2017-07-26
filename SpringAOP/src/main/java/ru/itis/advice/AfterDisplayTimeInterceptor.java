package ru.itis.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Date;

public class AfterDisplayTimeInterceptor implements AfterReturningAdvice {
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Time before launch from AFTER_ADVICE: " + new Date());
    }
}
