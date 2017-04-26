package ru.itis.di.agregation.notbest;

/**
 * 25.04.2017
 * Card
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Card {
    private int money;
    private String cardNumber;

    public Card(int money, String cardNumber) {
        this.money = money;
        this.cardNumber = cardNumber;
    }

    public int getRemainder() {
        return money;
    }
    public int getMoney(int money) {
        if (money <= this.money) {
            this.money -= money;
            return money;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
