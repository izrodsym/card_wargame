public class Player {
    private String name;
    private final Card[] cardsInHand = new Card[26];
    private final Card[] cardsTaken = new Card[52];

    Player(String name) {
        setName(name);
    }

    public Card playCard() {
        Card card = null;
        if (hasCard()) {
            boolean flag = false;
            for (int i = 0; i < this.cardsInHand.length; i++) {
                if (this.cardsInHand[i] == null) {
                    card = this.cardsInHand[i - 1];
                    this.cardsInHand[i - 1] = null;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                card = this.cardsInHand[this.cardsInHand.length - 1];
                this.cardsInHand[this.cardsInHand.length - 1] = null;
            }
            return card;
        } else {
            return null;
        }
    }

    public boolean hasCard() {
        for (Card card : this.cardsInHand) {
            if (card != null) {
                return true;
            }
        }
        return false;
    }

    public void setName(String name) {
        if (!name.equals("")) {
            this.name = name;
        } else {
            this.name = "Incorrect player name!";
        }
    }

    public void setCardsInHand(Card addCard) {
        for (int i = 0; i < this.cardsInHand.length; i++) {
            if (this.cardsInHand[i] == null) {
                this.cardsInHand[i] = addCard;
                break;
            }
        }
    }

    /**
     * Take all the cards from the pile and put it in cardsTaken
     * @param pile - object from where we take the cards
     */
    public void takePile(Pile pile) {
        Card[] cardsPile = pile.getPile();
        for (Card cardPile : cardsPile) {
            for (int j = 0; j < this.cardsTaken.length; j++) {
                if (this.cardsTaken[j] == null) {
                    this.cardsTaken[j] = cardPile;
                    break;
                }
            }
        }
        pile.emptyPile();
    }

    public int getCountOfCardsTaken() {
        int count = 0;
        for(Card card:cardsTaken){
            if(card != null){
                count ++;
            }
        }
        return count;
    }

    public String getName() {
        return name;
    }
}
