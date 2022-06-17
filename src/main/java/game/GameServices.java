package game;

import card.Card;
import card.NumberCard;
import player.Player;

import java.util.ArrayList;
import java.util.Collections;

public class GameServices {
    private Game game;

    public GameServices(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Desk getDesk() {
        return game.getDesk();
    }

    public boolean hasEndLevel() {
        for (Player player : game.getPlayers())
            if (!player.getNumberCard().isEmpty()) return false;
        return true;
    }

//    public boolean hasEndGame() {
//        return game.();
//    }

    public Card getRandomNumberCard() {
        return game.getNotPlayedNumberCards().pop();
    }

    public void giveNumberCard() {
        Collections.shuffle(game.getNotPlayedNumberCards());
        for (Player player : game.getPlayers()) {
            for (int i = 0; i < getDesk().getLevelCard().getLevel(); i++)
                player.getNumberCard().add(getRandomNumberCard());
        }
    }

    public boolean isCardValid(NumberCard playedNumberCard) {
        if (getDesk().getShownNumberCards().peek().getValue() < playedNumberCard.getValue()) return true;
        return false;
    }

    public void loseHeartCard() {
        if (!getDesk().getHeartCards().isEmpty()) getDesk().getHeartCards().remove(0);
    }


//    public ArrayList<NumberCard> useNinjaCard() {
//        if (!getDesk().getNinjaCards().isEmpty()) {
//
//        }
//    }
}