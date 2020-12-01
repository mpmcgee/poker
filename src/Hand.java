

public class Hand {
    private Card[] cards;
    private int[] value;



    Hand(Deck d){

        value = new int[6];
        cards = new Card[5];
        for (int i = 0; i < 5; i++){
            cards[i] = d.drawCard();
        }

        int[] ranks = new int[14];
        int matchingCardsR1 = 1; //matching cards of a rank
        int matchingCardsR2 = 1; //matching cards of a second rank
        int lowerRankMatch = 0;
        int higherRankMatch = 0;
        int index = 0;
        boolean flush = true;
        boolean straight = false;
        int topStraightRank = 0;
        int[] orderedRanks = new int[5];


        for (int r = 0; r <= 13; r++){
            ranks[r] = 0; // initialize ranks array as 0
        }

        for (int r = 0; r <= 4; r++){
            ranks[cards[r].getRank()] ++;
            //cycle through hand to get ranks
        }


        for (int i = 0; i < 4; i++){
            if (cards[i].getSuit() != cards[i+1].getSuit()){
                flush = false;
            }
        }

        for (int i = 13; i >= 1; i--){
            if (ranks[i] > matchingCardsR1){

                if (matchingCardsR1 != 1){
                    matchingCardsR2 = matchingCardsR1;
                    lowerRankMatch = higherRankMatch;

                }

                matchingCardsR1 = ranks[i];
                higherRankMatch = i;

            } else if (ranks[i] > matchingCardsR2){

                matchingCardsR2 = ranks[i];
                lowerRankMatch = i;

            }

        }

        if (ranks[1] == 1){

            orderedRanks[index] = 14; //ace is high record as 14 instead of 1
            index++;
        }

        for (int i = 13; i >= 2 ; i--){
            if (ranks[i] == 1){
                orderedRanks[index] = i;
                index++;
            }
        }

        for (int i = 1; i < 10; i++){
            if (ranks[i] == 1 && ranks[i+1] == 1 && ranks[i+2] == 1
                    && ranks[i+3] == 1 && ranks[i+4] == 1){

                straight = true;
                topStraightRank = i+4; // lower rank + 4
                break;
            }
        }

        if (ranks[10] == 1 && ranks[11] ==1 && ranks[12] == 1
                && ranks[13] == 1 && ranks[1] == 1) { //ace high

            straight = true;
            topStraightRank = 14;
        }

        for (int i = 0; i <= 5; i++){
            value[i] = 0;
        }

        //determine the value of hand

        if (matchingCardsR1 == 1){ //high card
            value[0] = 1;
            value[1] = orderedRanks[0];
            value[2] = orderedRanks[1];
            value[3] = orderedRanks[2];
            value[4] = orderedRanks[3];
            value[5] = orderedRanks[4];
        }

        if (matchingCardsR1 == 2 && matchingCardsR2 == 1){ // one pair
            value[0] = 2;
            value[1] = higherRankMatch;
            value[2] = orderedRanks[0];
            value[3] = orderedRanks[1];
            value[4] = orderedRanks[2];
        }

        if(matchingCardsR1 == 2 && matchingCardsR2 == 2){ // two pair

            value[0] = 3;
            value[1] = higherRankMatch > lowerRankMatch ? higherRankMatch : lowerRankMatch;
            value[2] = higherRankMatch < lowerRankMatch ? higherRankMatch : lowerRankMatch;
            value[3] = orderedRanks[0]; // other card in hand

        }

        if (matchingCardsR1 == 3 && matchingCardsR2 != 2){ // three of a kind
            value[0] = 4;
            value[1] = higherRankMatch;
            value[2] = orderedRanks[0];
            value[3] = orderedRanks[1];
        }

        if (straight && !flush){ //straight
            value[0] = 5;
            value[1]=0;
        }

        if (flush && !straight){ //flush
            value[0] = 6;
            value[1] = orderedRanks[0];
            value[2] = orderedRanks[1];
            value[3] = orderedRanks[2];
            value[4] = orderedRanks[3];
            value[5] = orderedRanks[4];
        }

        if (matchingCardsR1 == 3 && matchingCardsR2 == 2){ // full house
            value[0] = 7;
            value[1] = higherRankMatch;
            value[2] = lowerRankMatch;
        }

        if (matchingCardsR1 == 4) { // 4 of a kind
            value[0] = 8;
            value[1] = higherRankMatch;
            value[2] = orderedRanks[0];

        }

        if (straight && flush){
            value[0] = 9;
            value[1] = 0;
        }

    }

    void showScore(){
        String msg;
        switch (value[0]){

            case 1:
                msg = "high card";
                break;
            case 2:
                msg = "pair of " + Card.rankToString(value[1]) + "\'s";
                break;
            case 3:
                msg = "two pair " + Card.rankToString(value[1]) + " " +
                        Card.rankToString(value[2]);
                break;
            case 4:
                msg = "three of a kind " + Card.rankToString(value[1]) + "\'s";
                break;
            case 5:
                msg = Card.rankToString(value[1]) + " high straight";
                break;
            case 6 :
                msg = "flush";
                break;
            case 7:
                msg = "full house " + Card.rankToString(value[1]) + " over " +
                        Card.rankToString(value[2]);
                break;
            case 8:
                msg = "four of a kind " + Card.rankToString(value[1]);
                break;
            case 9:
                msg = "straight flush " + Card.rankToString(value[1]) + " high";
                break;
            default:
                msg = "error in hand.showScore: value[0] contains an invalid value";
            }
            System.out.println(msg);
    }

    void showHand(){

        for (int i = 0; i < 5; i++){
            System.out.println(cards[i]);
        }

    }



    int compareHands(Hand h){

        for (int i = 0; i <= 5; i++){
            if (this.value[i] > h.value[i]){
                return 1;
            } else if (this.value[i] < h.value[i]){
                return -1;
            }
        } return 0;
    }

    public Card[] getCards(){

        return cards;
    }


}
