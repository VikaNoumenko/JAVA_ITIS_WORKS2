package ru.itis;

/**
 * Данный класс мы хотим
 * изуродовать с помощью AOP
 */
public class ContainingLongLoopRunningMethodClass {
    // нам необходимо посмотреть
    // когда метод начал свое выполнение
    // когда метод закончил свое выполнение
    public void longLoop() {
        try {
            int delay = (int)(Math.random() * 10);
            System.out.println("Delay time " + delay);
            Thread.sleep(delay * 1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public void smallLongLoop() {
        try {
            int delay = (int)(Math.random() * 10);
            System.out.println("Small Delay time " + delay);
            Thread.sleep(delay * 100);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    public void someError() {
        throw new IllegalArgumentException("SOME ERROR");
    }
}
