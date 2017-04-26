package ru.itis.di.agregation.best;


/**
 * 25.04.2017
 * Terminal
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Terminal {
    private TerminalLogger logger;

    public Terminal(TerminalLogger terminalLogger) {
        this.logger = terminalLogger;
    }

    public int giveMoney(int money, Card card) {
        logger.log(card.getCardNumber(), "get money");
        return card.getMoney(money);
    }
}
