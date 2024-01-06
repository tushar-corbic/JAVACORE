package org.example;

import java.util.*;

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
        System.out.println(cards.size());

        List<Card> aceofHearts = Collections.nCopies(13, aceOfCard);
        Card.printDeck(aceofHearts, "Ace of Hears", 1);

        List<Card> temp = new ArrayList<>();
        temp = List.copyOf(aceofHearts);
        Card.printDeck(temp, "copy", 1);

        Collections.shuffle(deck);
        Card.printDeck(deck,"suffled", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "revered",4);

        Comparator<Card> sortingAlgorithm = Comparator.comparing((Card card)->card.rank).thenComparing((Card card)->card.suit);

        deck.sort( sortingAlgorithm);
        Card.printDeck(deck, "soretd deck", 13);

        int ans = Collections.binarySearch(deck, Card.getFaceCard(Card.Suit.CLUB,'K'), sortingAlgorithm);
        System.out.println(deck.get(ans));
        System.out.println(Collections.frequency(deck,deck.get(0)));
        Card.printDeck(deck);
        System.out.println(Collections.min(deck, sortingAlgorithm));
        System.out.println(Collections.max(deck, sortingAlgorithm));


        Collections.rotate(deck, 2);
        Card.printDeck(deck);
    }
}