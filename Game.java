package blackjack;

import  java.util.Random;

import java.util.Scanner;

public class Game {

    private Player player[] = new Player[4];
    public static GUI gui=new GUI();
    private Card deck[] = new Card[52];
    private static final Random r = new Random();
    private static int maxScore=0;
    private static Scanner input_player_name=new Scanner(System.in);


    public Card[] getDeck() {
        return deck;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void update_max_score(Player player){

        if(player.get_score_hand()>=maxScore&&player.get_score_hand()<=21){
            maxScore= player.get_score_hand();


        }

    }

  public int getMaxScore(){
        return maxScore;
    }

    public void generate_cards() {
        int counter = 0;
        for (int suit = 0; suit < 4; suit++) {
            for (int r = 0; r < 13; r++) {
                if (r > 9) {
                    this.deck[counter] = new Card(suit, r, 10);
                } else {
                    this.deck[counter] = new Card(suit, r, r + 1);
                }
                counter++;
            }
        }
    }

    public  Card draw_cards() {

        Card c = new Card();

        while (true) {

            int index = r.nextInt(52);

            if (deck[index] == null) {

                continue;

            }
            else {
                c = deck[index];

                deck[index] = null;

                break;
            }
        }
        return c;
    }

    public void set_information_of_players(){

        for(int i=0;i<4;i++){

            System.out.println("Enter player's name");

            String player_name=input_player_name.next();

            Player p=new Player(player_name);

            p.add_card(draw_cards());

            p.add_card(draw_cards());

            this.player[i]=p;



        }
    }

    public Player[] getPlayer() {
        return player;
    } //for gui

    public void display_deck(){

        for(Card e:deck){

            if(e!=null)

                System.out.println(e.getSuit()+" "+e.getRank()+" "+e.getValue());
        }
    }


}


