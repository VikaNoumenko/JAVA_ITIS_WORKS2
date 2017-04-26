package ru.itis.di.inherritance;

/**
 * 25.04.2017
 * Main
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        Card card = new Card(100, "777");
        Terminal terminal = new Terminal();
        terminal.giveMoney(5, card);
        System.out.println(card.getRemainder());

        LoggerRepairs repair = new LoggerRepairs();
        repair.repair(terminal);
        terminal.killClient();
    }
}
