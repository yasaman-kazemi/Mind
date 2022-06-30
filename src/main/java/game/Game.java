package game;

import card.Card;
import card.HeartCard;
import card.LevelCard;
import card.NumberCard;
import player.Player;

import java.util.Collections;
import java.util.Stack;

public class Game {
    private Player[] players;
    private Desk desk;
    private Stack<NumberCard> notPlayedNumberCards;
    private final int numberOfPlayers;

    public Game(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        players = new Player[numberOfPlayers];
        this.desk = new Desk(new Stack<>(), numberOfPlayers,
                2, new LevelCard(1));
    }


    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Desk getDesk() {
        return desk;
    }

    public void setDesk(Desk desk) {
        this.desk = desk;
    }

    public Stack<NumberCard> getNotPlayedNumberCards() {
        return notPlayedNumberCards;
    }

    public void setNotPlayedNumberCards(Stack<NumberCard> notPlayedNumberCards) {
        this.notPlayedNumberCards = notPlayedNumberCards;
    }


    public boolean hasEndLevel() {
        for (Player player : getPlayers())
            if (!player.getNumberCards().isEmpty()) return false;
        return true;
    }

    //if we lose all the heart cards, we lose.
    public GameStatus getStatus() {
        if (getLastLevel() == desk.getLevelCard().getLevel() && hasEndLevel()) return GameStatus.win;
        if (!desk.hasAvailableHeartCards()) return GameStatus.lose;
        return GameStatus.inProgress;
    }

    public int getLastLevel() {
        return 16 - (2 * numberOfPlayers);
    }

    public void goNextLevel() {
        Card gift = desk.getLevelCard().getGift();
        if (gift != null) {
            if (gift instanceof HeartCard) desk.increaseHeartCards();
            else desk.increaseNinjaCards();
        }
        desk.nextLevel();
    }

    public void giveNumberCard() {
        Collections.shuffle(getNotPlayedNumberCards());
        for (Player player : getPlayers()) {
            for (int i = 0; i < getDesk().getLevelCard().getLevel(); i++)
                player.getNumberCards().add(getRandomNumberCard());
            Collections.sort(player.getNumberCards());
        }
    }

    public NumberCard getRandomNumberCard() {
        return getNotPlayedNumberCards().pop();
    }

    public void reset() {
        notPlayedNumberCards.addAll(desk.getShownNumberCards());
        desk.getShownNumberCards().clear();
        giveNumberCard();
    }
}
