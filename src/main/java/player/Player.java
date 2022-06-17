package player;

import card.Card;
import card.NumberCard;

import java.util.ArrayList;


public class Player {
    private ArrayList<NumberCard> numberCard;
    private String name;

    public Player(String name) {
        this.numberCard = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<NumberCard> getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(ArrayList<NumberCard> numberCard) {
        this.numberCard = numberCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NumberCard popLowestNumberCard() {
        if (!numberCard.isEmpty()) {
            NumberCard lowestNumberCard = numberCard.get(0);
            numberCard.remove(0);
            return lowestNumberCard;
        }
        return null;
    }
}
