package card;

public class NumberCard extends Card implements Comparable<NumberCard> {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int compareTo(NumberCard o) {
        return Integer.compare(value, o.value);
    }
}
