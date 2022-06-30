package game;

import card.Card;
import card.HeartCard;
import card.LevelCard;
import card.NumberCard;
import player.Player;

import java.util.Stack;

public class Game {
    private Player[] players;
    private Desk desk;
    private Stack<NumberCard> notPlayedNumberCards;
    private int numberOfPlayers;

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

    public LevelCard goNextLevel() {
        Card gift = desk.getLevelCard().getGift();
        if (gift != null) {
            if (gift instanceof HeartCard) desk.increaseHeartCards();
            else desk.increaseNinjaCards();
        }
        return desk.nextLevel();
    }


    public void reset() {

    }
}
