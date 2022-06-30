package card;

public class LevelCard extends Card {
    private int level;
    private Card gift;

    public LevelCard(int level) {
        this.level = level;
        switch (level) {
            case 3:
            case 6:
            case 9:
                this.gift = new HeartCard();
                break;
            case 2:
            case 5:
            case 8:
                this.gift = new NinjaCard();
                break;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Card getGift() {
        return gift;
    }

    public void setGift(Card gift) {
        this.gift = gift;
    }

}
