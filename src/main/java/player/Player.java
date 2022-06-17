package player;

import card.Card;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> numberCard;
    private String name;

    public ArrayList<Card> getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(ArrayList<Card> numberCard) {
        this.numberCard = numberCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
