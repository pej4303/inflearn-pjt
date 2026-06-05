package section09_iterable.test;

public class Card {
    private final int number;
    private final String suit;

    public Card(int number, String suit) {
        this.number = number;
        this.suit = suit;
    }

    public int getNumber() {
        return number;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return number + "(" + suit + ")";
    }
}