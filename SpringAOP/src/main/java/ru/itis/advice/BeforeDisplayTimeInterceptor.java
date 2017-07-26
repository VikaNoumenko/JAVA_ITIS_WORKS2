package ru.itis.advice;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Date;

public class BeforeDisplayTimeInterceptor implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Time before launch from BEFORE_ADVICE: " + new Date());
    }
}
