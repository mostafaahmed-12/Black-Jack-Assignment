package blackjack;

public class Player {

    private String Name;
    private int index_of_card=0;
    private   boolean got_blackjack;
    private  boolean lost_or_not;
    private String player_status;
    private Card player_cards[] = new Card[11];


    public String getPlayer_status() {
        return player_status;
    }

    public void setPlayer_status(String player_status) {
        this.player_status = player_status;
    }

    public void setGot_blackjack(boolean got_blackjack) {
        this.got_blackjack = got_blackjack;
    }

    public void setLost_or_not(boolean lost_or_not) {
        this.lost_or_not = lost_or_not;
    }

    public boolean isLost_or_not() {
        return lost_or_not;
    }

    public boolean isGot_blackjack() {
        return got_blackjack;
    }

    public Player(String name) {
        Name = name;
    }

    public Player(){
        this.index_of_card=0;
        this.got_blackjack=false;
        this.lost_or_not=false;
    }

    public void add_card(Card card){

        this.player_cards[this.index_of_card]=card;

        index_of_card++;
    }

    public int get_score_hand(){

        int Score=0;

        for(int i=0;i<index_of_card;i++){

            Score+=player_cards[i].getValue();

        }
        return Score;

    }

    public Card[] getPlayer_cards() {
        return player_cards;
    } //for gui

    public String getName() {
        return Name;
    }

    public void print(){

        for(Card c:player_cards){

            if(c!=null)

                System.out.println(c.getSuit()+" "+c.getRank()+"  "+c.getValue());

        }
    }

    public int get_index(){

        return index_of_card;
    }

}
