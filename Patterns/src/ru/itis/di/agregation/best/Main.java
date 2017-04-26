package ru.itis.di.agregation.best;

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
        Terminal terminal = new Terminal(new TerminalLoggerSystemErrIml());
        terminal.giveMoney(10, card);
    }
}
