import org.apache.commons.lang3.ArrayUtils;

public class Deck {
    private String[] cardsInDeck;
    private String[] handDealt;
    private String[] suits = {"Spades", "Hearts", "Diamonds", "clubs"};
    private String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9",
            "10", "J", "Q", "K"};


    public void shuffleDeck() {

        for (int j = 0; j < suits.length; j++) {
            for (int i = 0; i < ranks.length; i++) {
                String value = ranks[i] + " of " + suits[j];
                this.cardsInDeck = ArrayUtils.add(cardsInDeck, value);
            }
        }
    }

    public String[] getDeck() {
        return cardsInDeck;
    }

    public String[] Deal(){



        for (int i = 0; i <= 5; i++){
            int index = (int)(Math.random()+10);
            String value = cardsInDeck[index];
            this.handDealt = ArrayUtils.add(handDealt, value);
            this.cardsInDeck = ArrayUtils.remove(cardsInDeck, index);
        }

        return handDealt;

    }

}