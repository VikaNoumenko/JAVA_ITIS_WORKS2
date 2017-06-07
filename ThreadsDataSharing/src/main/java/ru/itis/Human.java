package ru.itis;

// Human - монитор, закхватывает мьютекс, и держит его, пока процедура,
// в которой захвачен мьютекс не будет полностью выполнена
// bonusCard - мьютекс
public class Human extends Thread {
    private final BonusCard bonusCard;
    private String who;

    public Human(BonusCard bonusCard, String who) {
        this.bonusCard = bonusCard;
        this.who = who;
    }

    public void shopping(int bonuses) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        synchronized (bonusCard) {
            if (bonusCard.getBonuses() >= bonuses) {
                System.out.println(who + " is gonna by something");
                if (bonusCard.use(bonuses)) {
                    System.out.println(who + " bought something");
                } else {
                    System.out.println("Sorry, Honey, no money");
                }
            }
        }
    }

    public void run() {
        for (int i = 0; i < 25; i++) {
            shopping(7);
        }
    }
}
