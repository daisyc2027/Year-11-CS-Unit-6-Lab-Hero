import java.util.concurrent.TimeUnit;

public class Hero {
    private String name;
    public int hitPoints;

    public Hero(String name) {
        hitPoints = 100;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String toString() {
        return "Hero{" +
                "name='" + getName() + '\'' +
                ", hitPoints=" + getHitPoints() +
                '}';
    }

    public void attack(Hero opponent) {
        double random = Math.random();
        if (random < 0.5) {
            opponent.hitPoints -= 10;
        } else {
            hitPoints -= 10;
        }
    }

    public void senzuBean() {
        this.hitPoints = 100;
    }

    private void fightUntilTheDeathHelper(Hero opponent) {
        while (opponent.getHitPoints() > 0 && this.hitPoints > 0) {
            attack(opponent);
        }
    }

    public String fightUntilTheDeath(Hero opponent) {
        opponent.senzuBean();
        this.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return opponent.getName() + ": " + opponent.getHitPoints() + this.name + ": " + hitPoints;
    }

    public int[] nFightsToTheDeathHelper(Hero opponent, int n) {
        int[] wins = new int[2];
        int heroWins = 0;
        int opponentWins = 0;
        for (int i = 0; i < n; i++) {
            fightUntilTheDeath(opponent);
            if (hitPoints > 0) {
                heroWins++;
            }
            if (opponent.getHitPoints() > 0) {
                opponentWins++;
            }
        }
        wins[0] = heroWins;
        wins[1] = opponentWins;
        return wins;
    }

    public String nFightsToTheDeath(Hero opponent, int n) {
        int[] score = nFightsToTheDeathHelper(opponent, n);
        String result;
        if (score[0] != score[1]) {
            result = this.name + ": " + score[0] + " wins\n" + opponent.name + ": " + score[1] + " wins";
        } else {
            result = "OMG! It was actually a draw!";
        }
        return result;
    }

    public void dramaticFightToTheDeath(Hero opponent)  {
        while (opponent.getHitPoints() > 0 && this.hitPoints > 0) {
            attack(opponent);
            System.out.println(opponent.getName() + ": " + opponent.getHitPoints() + this.name + ": " + hitPoints);
            wait(1000);
        }
    }

    public static void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

}
