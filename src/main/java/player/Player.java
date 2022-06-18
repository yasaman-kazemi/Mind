package player;

import card.NumberCard;

import java.util.ArrayList;


public class Player {
    private ArrayList<NumberCard> numberCards;
    private String name;

    public Player(String name) {
        this.numberCards = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<NumberCard> getNumberCards() {
        return numberCards;
    }

    public void setNumberCards(ArrayList<NumberCard> numberCards) {
        this.numberCards = numberCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NumberCard popLowestNumberCard() {
        if (!numberCards.isEmpty()) {
            NumberCard lowestNumberCard = numberCards.get(0);
            numberCards.remove(0);
            return lowestNumberCard;
        }
        return null;
    }

//    public ArrayList<NumberCard> collectAllLowerNumberCard(NumberCard numberCard) {
//
//    }

    public boolean hasLowerNumberCard(NumberCard numberCard) {
        if (!numberCards.isEmpty()) return numberCards.get(0).getValue() < numberCard.getValue();
        return true;
    }
}
