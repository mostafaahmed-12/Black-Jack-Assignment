package blackjack;

public class Card {

    private int suit;
    private int rank;
    private int value;

    public Card(int suit,int rank,int value){

        this.suit=suit;

        this.value=value;

        this.rank=rank;

    }

    public Card(Card c){

        suit=c.suit;

        rank=c.rank;

        value=c.value;
    }
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }


    public Card() {


    }

}
