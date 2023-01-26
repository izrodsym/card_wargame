import java.util.Random;

public class WarGame {
    public static void main(String[] args) {
        Player player1 = new Player("Peter");
        Player player2 = new Player("Kiril");
        Card[] deck;
        deck = createCadrs();
        shuffle(deck);

        //roll the deck
        for (int i = 0; i < deck.length; i++) {
            if (i % 2 == 0) {
                player1.setCardsInHand(deck[i]);
            } else {
                player2.setCardsInHand(deck[i]);
            }
        }

        boolean flag = false;
        Pile pile = new Pile();

        //game start
        while (player1.hasCard() && player2.hasCard()) {
            //both players play a card
            Card cardP1 = player1.playCard();
            Card cardP2 = player2.playCard();
            pile.addCard(cardP1);
            pile.addCard(cardP2);
            System.out.println(cardP1.getCardName() + " : " + cardP2.getCardName());

            //check power of players cards
            if (cardP1.getPower() > cardP2.getPower()) {
                flag = false;
                player1.takePile(pile);
            } else if (cardP1.getPower() < cardP2.getPower()) {
                flag = false;
                player2.takePile(pile);
            } else {        // if the power of the cards is equal
                if (!flag) {    // if flag is false, their cards are equal for the first time
                    flag = true;
                    for (int i = 0; i < 2; i++) {      // both players throw 2 additional cards to pile
                        if (player1.hasCard()) {
                            pile.addCard(player1.playCard());
                        }
                        if (player2.hasCard()) {
                            pile.addCard(player2.playCard());
                        }
                    }
                    System.out.println("4 additional cards in pile.");
                }

            }

        }

        //player with cards in hand collect the pile, at this variant nobody will collect the pile
        if (flag) {
            if (player1.hasCard()) {
                player1.takePile(pile);
            } else if (player2.hasCard()) {
                player2.takePile(pile);
            }
        }


        if (player1.getCountOfCardsTaken() > player2.getCountOfCardsTaken()) {
            System.out.println(player1.getCountOfCardsTaken());
            System.out.println("Player " + player1.getName() + " wins!");
        } else if (player1.getCountOfCardsTaken() < player2.getCountOfCardsTaken()) {
            System.out.println(player2.getCountOfCardsTaken());
            System.out.println("Player " + player2.getName() + " wins!");
        } else {
            System.out.println("Draw!");
        }


    }

    public static void shuffle(Card[] deck) {
        Random randomGenerator = new Random();
        Card tempCard;
        for (int i = 0; i < deck.length; i++) {
            int index = randomGenerator.nextInt(deck.length);
            tempCard = deck[i];
            deck[i] = deck[index];
            deck[index] = tempCard;
        }
    }

    public static Card[] createCadrs() {
        Card[] cards = new Card[52];
        int counter = 0;
        String name = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 14; j++) {
                if (j <= 10) {
                    name = "" + j;
                } else {
                    switch (j) {
                        case 11:
                            name = "Jack";
                            break;
                        case 12:
                            name = "Queen";
                            break;
                        case 13:
                            name = "King";
                            break;
                        case 14:
                            name = "Ace";
                            break;
                        default:
                            break;
                    }
                }

                switch (i) {
                    case 0:
                        name = name + " Club";
                        cards[counter] = new Card(name, j);
                        break;
                    case 1:
                        name = name + " Diamand";
                        cards[counter] = new Card(name, j);
                        break;
                    case 2:
                        name = name + " Heart";
                        cards[counter] = new Card(name, j);
                        break;
                    case 3:
                        name = name + " Spade";
                        cards[counter] = new Card(name, j);
                        break;
                    default:
                        break;
                }
                counter++;
            }
        }
        return cards;
    }
}
