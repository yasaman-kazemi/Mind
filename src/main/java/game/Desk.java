package game;

import card.*;

import java.util.LinkedList;
import java.util.Stack;

public class Desk {
    private Stack<NumberCard> shownNumberCards;
    private LinkedList<HeartCard> heartCards;
    private LinkedList<NinjaCard> ninjaCards;
    private LevelCard levelCard;

    public Desk(Stack<NumberCard> shownNumberCards, LinkedList<HeartCard> heartCards,
                LinkedList<NinjaCard> ninjaCards, LevelCard levelCard) {
        this.shownNumberCards = shownNumberCards;
        this.heartCards = heartCards;
        this.ninjaCards = ninjaCards;
        this.levelCard = levelCard;
    }

    public Stack<NumberCard> getShownNumberCards() {
        return shownNumberCards;
    }

    public void setShownNumberCards(Stack<NumberCard> shownNumberCards) {
        this.shownNumberCards = shownNumberCards;
    }

    public LinkedList<HeartCard> getHeartCards() {
        return heartCards;
    }

    public void setHeartCards(LinkedList<HeartCard> heartCards) {
        this.heartCards = heartCards;
    }

    public LinkedList<NinjaCard> getNinjaCards() {
        return ninjaCards;
    }

    public void setNinjaCards(LinkedList<NinjaCard> ninjaCards) {
        this.ninjaCards = ninjaCards;
    }

    public LevelCard getLevelCard() {
        return levelCard;
    }

    public void setLevelCard(LevelCard levelCard) {
        this.levelCard = levelCard;
    }

}
