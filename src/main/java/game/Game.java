package game;

import card.HeartCard;
import card.LevelCard;
import card.NinjaCard;
import player.Player;

import java.util.LinkedList;
import java.util.Stack;

public class Game {
    private Player[] players;
    private Desk desk;

    public Game(int numberOfPlayers) {
        players = new Player[numberOfPlayers];
        this.desk = new Desk(new Stack<Number>(),new LinkedList<HeartCard>(),
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

}
