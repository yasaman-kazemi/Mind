package game;

import card.*;
import player.Player;

import java.util.LinkedList;
import java.util.Stack;

public class Game {
    private Player[] players;
    private Desk desk;
    private Stack<NumberCard> notPlayedNumberCards;
    private LinkedList<HeartCard> notPlayedHeartCards;
    private LinkedList<NinjaCard> notPlayedNinjaCard;
    private LinkedList<LevelCard> notPlayedLevelCard;

    public Game(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        this.desk = new Desk(new Stack<NumberCard>(), new LinkedList<HeartCard>(),
                new LinkedList<NinjaCard>(), new LevelCard(1));
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

    public LinkedList<HeartCard> getNotPlayedHeartCards() {
        return notPlayedHeartCards;
    }

    public void setNotPlayedHeartCards(LinkedList<HeartCard> notPlayedHeartCards) {
        this.notPlayedHeartCards = notPlayedHeartCards;
    }

    public LinkedList<NinjaCard> getNotPlayedNinjaCard() {
        return notPlayedNinjaCard;
    }

    public void setNotPlayedNinjaCard(LinkedList<NinjaCard> notPlayedNinjaCard) {
        this.notPlayedNinjaCard = notPlayedNinjaCard;
    }

    public LinkedList<LevelCard> getNotPlayedLevelCard() {
        return notPlayedLevelCard;
    }

    public void setNotPlayedLevelCard(LinkedList<LevelCard> notPlayedLevelCard) {
        this.notPlayedLevelCard = notPlayedLevelCard;
    }

//    public GameStatus getStatus() {
//        if()
//    }
}
