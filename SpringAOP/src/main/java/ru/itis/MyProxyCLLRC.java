package ru.itis;

import java.util.Date;

public class MyProxyCLLRC extends ContainingLongLoopRunningMethodClass {
    @Override
    public void longLoop() {
        System.out.println("Time before launch: " + new Date());
        super.longLoop();
        System.out.println("Time after launch: " + new Date());
    }
}
