import java.util.ArrayList;
import java.util.List;

public class ShuffleCardsDeck {
  enum CardType {
    HEART,
    DIAMOND,
    SPADE,
    CLUB
  }
  class Card {
    CardType cardType;
    char cardValue;

    public Card(CardType _cardType, char _cardValue) {
      cardType = _cardType;
      cardValue = _cardValue;
    }
  }

  public class Deck {
    List<Card> cards = new ArrayList<>(52);

    public Deck(boolean bInitializeEmpty) {
      if (!bInitializeEmpty) {
        buildSuite(CardType.SPADE);
        buildSuite(CardType.CLUB);
        buildSuite(CardType.DIAMOND);
        buildSuite(CardType.HEART);
      }
    }

    public Deck() {
      this(true);
    }

    private void buildSuite(CardType _cardType) {
      cards.add(new Card(_cardType, 'A'));
      cards.add(new Card(_cardType, '2'));
      cards.add(new Card(_cardType, '3'));
      cards.add(new Card(_cardType, '4'));
      cards.add(new Card(_cardType, '5'));
      cards.add(new Card(_cardType, '6'));
      cards.add(new Card(_cardType, '7'));
      cards.add(new Card(_cardType, '8'));
      cards.add(new Card(_cardType, '9'));
      cards.add(new Card(_cardType, '0'));
      cards.add(new Card(_cardType, 'J'));
      cards.add(new Card(_cardType, 'Q'));
      cards.add(new Card(_cardType, 'K'));
    }
  }

  public Deck shuffle(Deck deck) {
    int min = 0, max = 51;
    for (int i = 0; i < 52; i++) {
      int random = (int) (min + Math.random() * (max - min));
      Card temp = deck.cards.get(i);
      deck.cards.remove(i);
      deck.cards.add(random, temp);
    }

    return deck;

  }

  public static void main(String[] args) {
    ShuffleCardsDeck shuffler = new ShuffleCardsDeck();
    ShuffleCardsDeck.Deck deck = shuffler.new Deck(false);
    Deck shuffledDeck = shuffler.shuffle(deck);
    System.out.println("size >> " + shuffledDeck.cards.size());
    shuffledDeck = shuffler.shuffle(shuffledDeck);
    shuffledDeck.cards.forEach((card) -> System.out.println(card.cardValue + "" + card.cardType.name()));
  }
}
