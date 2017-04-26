package ru.itis.di.inherritance;


/**
 * 25.04.2017
 * Terminal
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Terminal extends TerminalLogger {
    public int giveMoney(int money, Card card) {
        log(card.getCardNumber(), "get money");
        return card.getMoney(money);
    }
}
