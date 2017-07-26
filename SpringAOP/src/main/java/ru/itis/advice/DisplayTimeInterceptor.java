package ru.itis.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Date;

public class DisplayTimeInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        // время до создания задержки
        System.out.println("Time before launch: " + new Date());
        // вызвали метод на выполнение
        Object value = invocation.proceed();
        // вывели время после выполнения метода
        System.out.println("Time after launch: " + new Date());
        return value;
    }
}
