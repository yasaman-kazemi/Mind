package game;

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

    public void start() {
        giveNumberCard();
    }

    public void play(Player player) {
        NumberCard numberCard = player.popLowestNumberCard();
        getDesk().putNumberCard(numberCard);
    }

    public Desk getDesk() {
        return game.getDesk();
    }

    public NumberCard getRandomNumberCard() {
        return game.getNotPlayedNumberCards().pop();
    }

    public void giveNumberCard() {
        Collections.shuffle(game.getNotPlayedNumberCards());
        for (Player player : game.getPlayers()) {
            for (int i = 0; i < getDesk().getLevelCard().getLevel(); i++)
                player.getNumberCards().add(getRandomNumberCard());
            Collections.sort(player.getNumberCards());
        }
    }


    public boolean isCardValid(NumberCard playedNumberCard) {
        if (getDesk().getShownNumberCards().peek().getValue() < playedNumberCard.getValue()) return true;
        return false;
    }

    public boolean hasAnyoneLowerNumberCard(NumberCard numberCard) {
        for (Player player : game.getPlayers()) {
            if (player.hasLowerNumberCard(numberCard)) return true;
        }
        return false;
    }

    public void loseHeartCard() {
        if (getDesk().hasAvailableHeartCards()) getDesk().decreaseHeartCards();
    }


    public ArrayList<NumberCard> useNinjaCard() {
        if (getDesk().hasAvailableNinjaCards()) {
            ArrayList<NumberCard> result = new ArrayList<>();
            for (Player player : game.getPlayers()) {
                NumberCard lowestNumberCard = player.popLowestNumberCard();
                result.add(lowestNumberCard);
            }
            return result;
        }
        return null;
    }

    public void loseNinjaCard() {
        if (getDesk().hasAvailableNinjaCards()) getDesk().decreaseNinjaCards();
    }
}
