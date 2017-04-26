package ru.itis.di.agregation.best;

/**
 * 25.04.2017
 * TerminalLoggerSystemErrIml
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class TerminalLoggerSystemErrIml implements TerminalLogger {
    private int paintBalance;

    public void log(String cardNumber, String operation) {
        this.paintBalance -= 5;
        System.err.println(cardNumber + " " + operation);
    }

    public void setPaintBalance(int paintBalance) {
        this.paintBalance = paintBalance;
    }
}
