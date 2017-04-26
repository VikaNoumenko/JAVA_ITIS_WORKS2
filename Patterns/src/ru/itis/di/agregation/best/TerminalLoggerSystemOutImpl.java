package ru.itis.di.agregation.best;

/**
 * 25.04.2017
 * TerminalLoggerSystemOutImpl
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TerminalLoggerSystemOutImpl implements TerminalLogger {
    private int paintBalance;

    public void log(String cardNumber, String operation) {
        this.paintBalance -= 5;
        System.out.println(cardNumber + " " + operation);
    }

    public void setPaintBalance(int paintBalance) {
        this.paintBalance = paintBalance;
    }
}
