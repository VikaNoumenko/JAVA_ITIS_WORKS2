package ru.itis.classic.lazy.threads.safe;

// синглтон с ленивой инициализацией
public class Singleton {
    // instance - единственный экзмепляр
    private static volatile Singleton instance = null;

    // приватный конструктор
    private Singleton() {
    }

    // статический метод требования объекта
    public static Singleton getInstance() {
        // блокируем класс, следовательно
        // остальные потоки не могут получить
        // доступ, даже если объект уже инициализирован
        synchronized(Singleton.class) {
            if (instance == null) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
