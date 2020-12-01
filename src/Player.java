//import java.lang.String;

public class Player {
    private String name;
    private Hand[] hand;
    private Card[] cards;



    public String getName() {

        return name;
    }

    public void setName(String n) {

        name = n;
    }

//    public void setHand(Hand[] h) {
//
//        hand = h.getCards();
//    }

//    void showHand() {
//
//        hand.showHand();
//
//    }
}

//    public void setScore(String[] hand) {
//        //create 2d array of rank and suit for cards in hand
//        //set rank in first dimension
//        for (int i = 0; i <= hand.length; i++) {
//            for (int j = 0; j <= hand.length; j++) {
//                ArrayUtils.add(cardsToScore, hand[i].charAt(0));
//            }
//        //set suit in second dimension
//        } While
//            for (int j = 0; j <= hand.length; j++) {
//
//            for (int i = 0; i <= hand.length; i++) {
//                ArrayUtils.add(cardsToScore, (hand[j].charAt((hand[j].lastIndexOf(" ")) + 1)));
//            }
//        }



//    public int getScore() {
//        return score;
//    }
//}