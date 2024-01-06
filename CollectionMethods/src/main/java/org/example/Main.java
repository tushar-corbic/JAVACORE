package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfCard = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfCard);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Heat", 1);

        List<Card> cards = new ArrayList<>(52);
        Collections.fill(cards,aceOfCard );
        Card.printDeck(cards, "Ace of Hearts",1);
        System.out.println(cards.size());

        List<Card> aceofHearts = Collections.nCopies(13, aceOfCard);
        Card.printDeck(aceofHearts, "Ace of Hears", 1);

        List<Card> temp = new ArrayList<>();
        temp = List.copyOf(aceofHearts);
        Card.printDeck(temp, "copy", 1);
        
    }
}