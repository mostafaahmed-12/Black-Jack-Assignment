//                                                                     بسم الله الرحمن الرحيم

/* OOP ASSIGNMENT 1
THIS IS A PROJECT DESIGN BY MOSTAFA AHMED AHMED MOHAMED EL-HENAWEY
 SECTION 28
 ID 20201700822
COMPUTER SCIENCES ASU*/

package blackjack;

import java.util.Random;

import java.util.Scanner;

class THE_MAIN_CLASS{

  private   static   Game  game = new Game();
     private  static  GUI gui=new GUI();


    private static void win_push(Player player[]) {
        int count_black_jack = 0;

        int winner_player = 0, index = 0;

        for (int i = 0; i < 4; i++) {
            if (player[i].get_score_hand() == 21) {

                count_black_jack++;

                index = i;
            }
        }

        if (count_black_jack > 1) {

            System.out.println(" !!! PUSH !!!");
        }

        else if (count_black_jack == 0) {

            int max = 0;

            for (int i = 0; i < 4; i++) {

                if (player[i].get_score_hand() > 21) {

                    player[i].setLost_or_not(false);


                }

                else if ((player[i].get_score_hand() > max) && (max < 21) && (player[i].get_score_hand() < 21)) {

                    max = player[i].get_score_hand();

                    winner_player = i;

                    player[i].setLost_or_not(true);

                    player[i].setGot_blackjack(false);


                }
            }


            int c = 0;

            for (int i = 0; i < 4; i++) {

                if (player[i].get_score_hand() == max)

                    c++;
            }

            if (c == 1) {

                if (player[winner_player].isLost_or_not()) {

                    System.out.println(player[winner_player].getName() + "  " + " WIN " + player[winner_player].get_score_hand());
                }
            }

            else {

                int all_players_busted=0;

                for (int i = 0; i < 4; i++) {

                    if(!player[i].isLost_or_not()){

                        all_players_busted=1;
                    }
                }

                if(all_players_busted==1){

                    System.out.println(" !!! ALL PLAYERS BUSTED !!!");
                }

            }


        }


        else if (count_black_jack == 1) {

            player[index].setGot_blackjack(true);

            player[index].setLost_or_not(true);

            System.out.println(player[index].getName() + "  " + "Black_Jack");


        }



    }

    private static void dealer(Player dealer){
        System.out.println("the_score_of_dealer: before draw " + dealer.get_score_hand());

        if(dealer.get_score_hand()>game.getMaxScore()) {

            dealer.setLost_or_not(true);

            if(dealer.get_score_hand()==21){

                dealer.setGot_blackjack(true);
            }
        }
        else{


            while (true){

                Card c=new Card();

                c= game.draw_cards();

                dealer.add_card(c);

                gui.updateDealerHand(c, game.getDeck());

                if(dealer.get_score_hand()>game.getMaxScore()) {

                    dealer.setLost_or_not(true);

                    if(dealer.get_score_hand()==21){

                        dealer.setGot_blackjack(true);
                    }
                    break;
                }

                if(dealer.get_score_hand()>21){

                    dealer.setGot_blackjack(false);

                    dealer.setLost_or_not(false);

                    break;
                }

                else if(dealer.get_score_hand()==21){

                    dealer.setGot_blackjack(true);

                    dealer.setLost_or_not(true);

                    break;
                }


            }
            System.out.println("the_score_of_dealer: after " + dealer.get_score_hand());

        }

    }

    private static void HIT_OR_STAND(Player player[]){

        Scanner input = new Scanner(System.in);

        int ans=1;

        for (int i = 0; i < 3; i++) {

            System.out.println(player[i].getName() + "   " + "Your Score is: " + player[i].get_score_hand());

            System.out.println("Do you want to 1: hit or 2: stand");

            ans = input.nextInt();

            //     game.update_max_score(player[i]);

            while (ans == 1 && player[i].get_score_hand() < 21) {

                Card c = new Card();

                c = game.draw_cards();

                player[i].add_card(c);

                gui.updatePlayerHand(c, i);

                // game.update_max_score(player[i]);

                if (player[i].get_score_hand() > 21) {

                    player[i].setLost_or_not(false);

                    player[i].setGot_blackjack(false);




                    System.out.println(player[i].getName() + " Busted " + "  Your Score is: " + player[i].get_score_hand());

                    break;
                } else if (player[i].get_score_hand() == 21) {

                    player[i].setGot_blackjack(true);

                    player[i].setLost_or_not(true);

                    player[i].setPlayer_status("Black_jack");

                    System.out.println(player[i].getName() + " Your Score is: " + player[i].get_score_hand());

                    break;
                }

                System.out.println(player[i].getName() + "   " + "Your Score is: " + player[i].get_score_hand());

                System.out.println("Do you want to  hit or stand " + (i + 1));

                ans = input.nextInt();

                if (ans == 2) {

                    continue;

                }

            }


        }  //take the cards and hit or stand




    }

    public static void the_game(){
        game.generate_cards();

        game.set_information_of_players();

 gui.runGUI(game.getDeck(), game.getPlayer()[0].getPlayer_cards(),game.getPlayer()[1].getPlayer_cards(),game.getPlayer()[2].getPlayer_cards(),game.getPlayer()[3].getPlayer_cards());

        Player player[] = new Player[4];

        player = game.getPlayer();

        HIT_OR_STAND(player);

        int max=0;
        for(int i=0;i<3;i++){
            if(player[i].get_score_hand()>max&&max<=21&&player[i].get_score_hand()<=21){
                max=player[i].get_score_hand();
                game.update_max_score(player[i]);

            }
            else {
                continue;
            }

        }
        dealer(player[3]);

        win_push(player);

        System.out.println("the_max_score_of_game_is: "+game.getMaxScore());

    }//The_main_function


}


public class BlackJack {


    public static void main(String[] args) {

       THE_MAIN_CLASS.the_game();


    }


}
