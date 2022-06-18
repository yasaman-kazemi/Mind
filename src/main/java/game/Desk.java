package game;

import card.LevelCard;
import card.NumberCard;

import java.util.Stack;

public class Desk {
    private Stack<NumberCard> shownNumberCards;
    private LevelCard levelCard;
    private int availableHeartCards;
    private int availableNinjaCards;


    public Desk(Stack<NumberCard> shownNumberCards, int availableHeartCards,
                int availableNinjaCards, LevelCard levelCard) {
        this.shownNumberCards = shownNumberCards;
        this.availableHeartCards = availableHeartCards;
        this.availableNinjaCards = availableNinjaCards;
        this.levelCard = levelCard;
    }

    public Stack<NumberCard> getShownNumberCards() {
        return shownNumberCards;
    }

    public void setShownNumberCards(Stack<NumberCard> shownNumberCards) {
        this.shownNumberCards = shownNumberCards;
    }

    public LevelCard getLevelCard() {
        return levelCard;
    }

    public void setLevelCard(LevelCard levelCard) {
        this.levelCard = levelCard;
    }

    public int getAvailableHeartCards() {
        return availableHeartCards;
    }

    public void setAvailableHeartCards(int availableHeartCards) {
        this.availableHeartCards = availableHeartCards;
    }

    public int getAvailableNinjaCards() {
        return availableNinjaCards;
    }

    public void setAvailableNinjaCards(int availableNinjaCards) {
        this.availableNinjaCards = availableNinjaCards;
    }

    public boolean hasAvailableHeartCards() {
        return availableHeartCards > 0;
    }

    public boolean hasAvailableNinjaCards() {
        return availableNinjaCards > 0;
    }

    public void decreaseHeartCards() {
        availableHeartCards--;
    }

    public void increaseHeartCards() {
        availableHeartCards++;
    }

    public void decreaseNinjaCards() {
        availableNinjaCards--;
    }

    public void increaseNinjaCards() {
        availableNinjaCards++;
    }

    public void putNumberCard(NumberCard numberCard) {
        shownNumberCards.push(numberCard);
    }
}
