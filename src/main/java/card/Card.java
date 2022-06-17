package card;

public abstract class Card {
    protected boolean isAlive;

    public boolean getAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
