/**
* author: Javed Attar
*/
package learn.javed.algorithms.arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * CardGame_II
 * 
 * @author jattar
 *
 */
public class CardGame_II {

	public static void main(String args[]) throws Exception {
		List<String> players = Arrays.asList("A", "B", "C", "D");
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		new CardGame_II().play(players);
	}

	List<String> players = new ArrayList<>();
	List<Card> deck = new ArrayList<>(52);
	Map<String, Deque<Card>> playerCards = new HashMap<>();
	Map<String, List<Hand>> playerWonHands = new HashMap<>();

	class Player {
		String name;

		public Player(String _name) {
			name = _name;
		}

		@Override
		public int hashCode() {
			return 10000 + Objects.hash(name);
		}

		@Override
		public boolean equals(Object obj) {

			if (obj == null || obj instanceof Player) {
				return false;
			}
			Player that = (Player) obj;
			return name.equals(that.name);
		}
	}

	class Score {
		String name;
		int score;

		public Score(String _name, int _score) {
			this.score = _score;
			this.name = _name;
		}

		@Override
		public String toString() {

			return name + "'s score=" + score;
		}
	}

	class HighCard {
		String name;
		int card;

		public HighCard(String _name, int _score) {
			this.card = _score;
			this.name = _name;
		}

		@Override
		public String toString() {

			return name + "'s high card =" + card;
		}
	}

	class Hand {
		Map<String, Card> cards = new HashMap<>();

		public void add(Card card, String player) {
			cards.put(player, card);
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (Map.Entry<String, Card> item : cards.entrySet()) {
				sb.append(item.getKey()).append(" = ").append(item.getValue().value).append(" | ");
			}
			sb.replace(sb.length() - 2, sb.length(), "");
			sb.append("]");
			return sb.toString();
		}

		public Score findWinner() {
			int maxCard = -1;
			String player = null;
			for (Map.Entry<String, Card> item : cards.entrySet()) {
				if (maxCard < item.getValue().value) {
					maxCard = item.getValue().value;
					player = item.getKey();
				}
			}

			return new Score(player, maxCard);
		}

		public HighCard findHighCard() {
			int maxCard = -1;
			String player = null;
			for (Map.Entry<String, Card> item : cards.entrySet()) {
				if (maxCard < item.getValue().value) {
					maxCard = item.getValue().value;
					player = item.getKey();
				}
			}

			return new HighCard(player, maxCard);
		}

	}

	class Card {
		int value;

		public Card(int _value) {
			value = _value;
		}

		public int getValue() {
			return value;
		}
	}

	public CardGame_II() {
		_initialize();
		shuffle();
	}

	private void _initialize() {
		for (int i = 1; i <= 52; i++) {
			deck.add(new Card(i));
		}
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public void distributeCards() {

		int counter = 0;
		int playerCounter = 0;

		while (counter < 52) {
			if (playerCounter == players.size())
				playerCounter = 0;
			String playerName = players.get(playerCounter++);
//			Player player = new Player(playerName);
			Deque<Card> cards = playerCards.getOrDefault(playerName, new ArrayDeque<Card>());
			cards.push(deck.get(counter++));
			playerCards.put(playerName, cards);

		}

	}

	public List<Score> scoreCard() {
		List<Score> scoreCard = new ArrayList<>();
		for (String player : players) {
			scoreCard.add(new Score(player, score(player)));
		}
		return scoreCard;

	}

	public int score(String playerName) {
		if (playerWonHands.containsKey(playerName)) {
			List<Hand> hands = playerWonHands.get(playerName);
			int score = 0;
			for (Hand hand : hands) {
				score += hand.cards.size();
			}
			System.out.println(playerName + "'s score=" + score);
			return score;
		} else {
			// throw exception
			System.out.println(playerName + "'s score=0");
			return 0;
		}
//		score(new Player(playerName));
	}

//	public void score(Player player) {
//		
//
//	}

	public void play(List<String> players) throws InterruptedException {
		this.players = players;
		distributeCards();
		int numOfGames = (52 / players.size());
		if (52 % players.size() != 0)
			numOfGames += 1;

		while (numOfGames > 0) {
			Hand hand = new Hand();
			for (Map.Entry<String, Deque<Card>> item : playerCards.entrySet()) {
				Deque<Card> remainingCards = item.getValue();
				if (!remainingCards.isEmpty()) {
					Card card = remainingCards.pop();
					System.out.println(item.getKey() + "'s card = " + card.value);
					hand.add(card, item.getKey());
				}
			}
			HighCard handWinner = hand.findHighCard();
			System.out.println("\n" + handWinner.name + "'s card = " + handWinner.card + " wins\n");
			List<Hand> winnerHands = playerWonHands.getOrDefault(handWinner.name, new ArrayList<>());
			winnerHands.add(hand);
			playerWonHands.put(handWinner.name, winnerHands);
			numOfGames--;
//			Thread.sleep(300);
		}
		findGameWinner();
	}

	private void findGameWinner() {

		List<Score> scoreCard = scoreCard();
		Collections.sort(scoreCard, new Comparator<Score>() {

			@Override
			public int compare(Score o1, Score o2) {
				return o2.score - o1.score;
			}
		});
//		System.out.println(scoreCard);

		System.out.println("Game winner ");
		checkTieAndResolve(scoreCard);
//		System.out.println(winner.getKey() + "'s winning Hands ");
	}

	private void checkTieAndResolve(List<Score> scoreCard) {
		List<Score> winners = new ArrayList<>();
		Score winner = scoreCard.get(0);
		winners.add(winner);
		for (int i = 1; i < scoreCard.size(); i++) {
			if (winner.score == scoreCard.get(i).score) {
				winners.add(scoreCard.get(i));
			}

		}
		if (winners.size() == 1) {
			System.out.println(winner);
			return;
		}

		System.out.println(resolveTie(winners));

	}

	private HighCard resolveTie(List<Score> winners) {
		List<Hand> allHands = new ArrayList<>();
		for (Score winner : winners) {
			allHands.addAll(playerWonHands.get(winner.name));
		}

		System.out.println(allHands);
		return findHighCard(allHands);
	}

	private HighCard findHighCard(List<Hand> list) {
		return Collections.max(list, new Comparator<Hand>() {

			@Override
			public int compare(Hand o1, Hand o2) {

				return o1.findHighCard().card - o2.findHighCard().card;
			}

		}).findHighCard();
	}
}
