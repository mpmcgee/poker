import java.util.Scanner;

public class Poker {

    public static void main(String[] args){

        String p1name;
        String[] cardsInDeck;
        String[] p1Hand;

        //prompt player1 for their name
        System.out.println("Player 1: Please enter your name. ");

        //crete scanner for input
        Scanner inputDevice = new Scanner(System.in);

        p1name = inputDevice.nextLine();

        Player p1 = new Player();

        p1.setName(p1name);

        System.out.println("Hello " + p1.getName() + ".");

        //create deck
        Deck d = new Deck();

        //store cards in array to form deck
        d.shuffleDeck();


        //deal to player 1
        p1Hand = d.Deal();

        //get deck
        cardsInDeck = d.getDeck();


//        for (int i = 0; i < cardsInDeck.length; i++){
//            System.out.println("Cards in deck: " + cardsInDeck[i]);
//        }
//
//        for (int i = 0; i < p1Hand.length; i++){
//            System.out.println("Cards in hand: " + p1Hand[i]);
//        }





    }

}
