package ru.itis.advice;

import org.springframework.aop.ThrowsAdvice;

public class ThrowsAdviceImpl implements ThrowsAdvice {
    public void afterThrowing(Exception ex) {

        if (ex.getMessage().equals("SOME ERROR")) {
            System.out.println("Error in Advice");
        } else {
            System.out.println("UNDEFINED ERROR");
        }
    }
}
