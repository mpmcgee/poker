import java.util.Scanner;

public class Poker {

    public static void main(String[] args) {

        String p1name;

        //create deck
        Deck d = new Deck();

        Hand h1 = new Hand(d);

        Hand h2 = new Hand(d);




        //prompt player1 for their name
        System.out.println("Player 1: Please enter your name. ");

        //crete scanner for input
        Scanner inputDevice = new Scanner(System.in);

        p1name = inputDevice.nextLine();

        Player p1 = new Player();

        Player p2 = new Player();

        p1.setName(p1name);

        System.out.println("Hello " + p1.getName() + ".");

        int cardsLeft = d.getRemainingCards();

        System.out.println(cardsLeft);

        h1.showHand();

        h1.showScore();

        h2.showScore();

        if (h1.compareHands(h2) == 1){
            System.out.println(p1.getName() + " wins!");
        } else{
            System.out.println("P2 wins!");
        }






    }
}