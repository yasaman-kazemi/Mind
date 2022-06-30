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
        game.giveNumberCard();
    }

    //todo check level has end
    public String play(Player player) {
        String result;
        NumberCard numberCard = player.popLowestNumberCard();
        if (isCardValid(numberCard)) {
            getDesk().putNumberCard(numberCard);
            result = noticeStatus();
        } else result = wrongCardPlayed(numberCard);
        if (game.hasEndLevel()) game.goNextLevel();
        return result;
    }

    public boolean isCardValid(NumberCard playedNumberCard) {
        return !hasAnyoneLowerNumberCard(playedNumberCard);
    }

    public String noticeStatus() {
        return "Game status = " + game.getStatus().toString() + "\n" +
                "Level = " + getDesk().getLevelCard().getLevel();
    }

    public String wrongCardPlayed(NumberCard numberCard) {
        loseHeartCard();
        if (game.getStatus() == GameStatus.inProgress) {
            ArrayList<NumberCard> result = new ArrayList<>();
            for (Player player : game.getPlayers())
                result.addAll(player.collectAllLowerNumberCard(numberCard));
            Collections.sort(result);
            getDesk().putAllNumberCards(result);
        }
        return noticeStatus();
    }

    public Desk getDesk() {
        return game.getDesk();
    }


    public boolean hasAnyoneLowerNumberCard(NumberCard numberCard) {
        for (Player player : game.getPlayers())
            if (player.hasLowerNumberCard(numberCard) || player.getNumberCards().isEmpty()) return true;
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
