package ru.itis.di.agregation.best;

/**
 * 25.04.2017
 * TerminalLogger
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface TerminalLogger {
    void log(String cardNumber, String operation);
    void setPaintBalance(int paintBalance);
}
