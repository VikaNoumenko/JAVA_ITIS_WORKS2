package ru.itis;

/**
 * 1. Функциональный интерфейс - интерфейс с одним методом
 например: Runnable
 2. Анонимный класс - класс, у которого нет имени и он объявляется явно
 */
public class Program {
    public static void main(String[] args) {
        MessageRenderer renderer = new MessageRenderer() {
            @Override
            public void showMessage(String text) {
                System.out.println(text);
            }
        };

        renderer.showMessage("Hello");

        MessageRenderer errorRenderer = text -> System.err.println(text);

        errorRenderer.showMessage("Bye");

        Mom mom = () -> {
            System.out.println("Покушай, сына");
            System.out.println("Ложись спать, не гуляй с девочками");
        };
    }
}
