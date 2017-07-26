package ru.itis;

import org.springframework.aop.framework.ProxyFactory;
import ru.itis.advice.AfterDisplayTimeInterceptor;
import ru.itis.advice.BeforeDisplayTimeInterceptor;
import ru.itis.advice.DisplayTimeInterceptor;
import ru.itis.advice.ThrowsAdviceImpl;

public class Program {
    public static void main(String[] args) {
        /* MethodInterceptor
        // создали экзепляр класс с задержкой
        ContainingLongLoopRunningMethodClass target =
                new ContainingLongLoopRunningMethodClass();
        // создали класс фабрику-прокси
        ProxyFactory proxyFactory = new ProxyFactory();
        // в фабрику положили исходный класс
        proxyFactory.setTarget(target);
        // положили в фабрику совет
        proxyFactory.addAdvice(new DisplayTimeInterceptor());
        // получили proxy-объект
        ContainingLongLoopRunningMethodClass proxy =
                (ContainingLongLoopRunningMethodClass)proxyFactory.getProxy();


        proxy.longLoop();

        ContainingLongLoopRunningMethodClass longLoopRunningMethodClass =
                new MyProxyCLLRC();

        longLoopRunningMethodClass.longLoop();
        */

        ContainingLongLoopRunningMethodClass target =
                new ContainingLongLoopRunningMethodClass();

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(new BeforeDisplayTimeInterceptor());
        proxyFactory.addAdvice(new AfterDisplayTimeInterceptor());
        proxyFactory.addAdvice(new DisplayTimeInterceptor());
        proxyFactory.addAdvice(new ThrowsAdviceImpl());

        ContainingLongLoopRunningMethodClass proxy =
                (ContainingLongLoopRunningMethodClass)proxyFactory.getProxy();

        proxy.smallLongLoop();
        proxy.someError();
    }
}
