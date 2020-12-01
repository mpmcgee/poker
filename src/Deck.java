import org.apache.commons.lang3.ArrayUtils;
import java.util.Random;
import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    Deck(){
        cards = new ArrayList<Card>();
//        int i, j;
//
//        Card temp;

        for (short i = 0; i <= 3; i++){
            for (short j = 0; j<=12; j++){
                cards.add(new Card(i,j));
            }
        }
    }

    public Card drawCard(){
        Random getRandom = new Random();
        int index = getRandom.nextInt( cards.size() - 1);
        return cards.remove(index);
    }

    public int getRemainingCards(){

        return cards.size();

    }









}