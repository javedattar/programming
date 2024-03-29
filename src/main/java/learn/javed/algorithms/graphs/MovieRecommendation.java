/**
* author: Javed Attar
*/
package learn.javed.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
You are analyzing data for Aquaintly, a hot new social network.

One of the fun features of Aquaintly is that users can rate movies they have seen from 1 to 5. We want to use these ratings to make movie recommendations.

Ratings will be provided in the following format:
  [Member Name, Movie Name, Rating]

We consider two users to have similar taste in movies if they have both rated the same movie as 4 or 5. 

A movie should be recommended to a user if:
- They haven't rated the movie
- A user with similar taste has rated the movie as 4 or 5

Example: 
ratings = [
    ["Alice", "Frozen", "5"],
    ["Bob", "Mad Max", "5"],
    ["Charlie", "Lost In Translation", "4"],
    ["Charlie", "Inception", "4"],
    ["Bob", "All About Eve", "3"],
    ["Bob", "Lost In Translation", "5"],
    ["Dennis", "All About Eve", "5"],
    ["Dennis", "Mad Max", "4"],
    ["Charlie", "Topsy-Turvy", "2"],
    ["Dennis", "Topsy-Turvy", "4"],
    ["Alice", "Lost In Translation", "1"]
]
If we want to recommend a movie to Charlie, we would recommend "Mad Max" because:
- Charlie has not rated "Mad Max"
- Charlie and Bob have similar taste as they both rated "Lost in Translation" 4 or 5
- Bob rated "Mad Max" a 5

Write a function that takes the name of a user and a collection of ratings, and returns a collection of all movie recommendations that can be made for the given user.

All test cases:
recommendations("Charlie", ratings) => ["Mad Max"]
recommendations("Bob", ratings) => ["Inception", "Topsy-Turvy"]
recommendations("Dennis", ratings) => ["Lost In Translation"]
recommendations("Alice", ratings) => []

Complexity Variable:
R = number of ratings
M = number of movies
U = number of users
*/
public class MovieRecommendation {
	public static void main(String[] argv) {
		String[][] ratings = { { "Alice", "Frozen", "5" }, { "Bob", "Mad Max", "5" },
				{ "Charlie", "Lost In Translation", "4" }, { "Charlie", "Inception", "4" },
				{ "Bob", "All About Eve", "3" }, { "Bob", "Lost In Translation", "5" },
				{ "Dennis", "All About Eve", "5" }, { "Dennis", "Mad Max", "4" }, { "Charlie", "Topsy-Turvy", "2" },
				{ "Dennis", "Topsy-Turvy", "4" }, { "Alice", "Lost In Translation", "1" } };

		System.out.println("Recommendations >> " + getRecommendations("Charlie", ratings));
		System.out.println("Recommendations >> " + getRecommendations("Bob", ratings));
		System.out.println("Recommendations >> " + getRecommendations("Dennis", ratings));
		System.out.println("Recommendations >> " + getRecommendations("Alice", ratings));
	}

	public static List<String> getRecommendations(String userName, String[][] ratings) {
		Map<String, Map<String, Integer>> userMovieMap = new HashMap<>();
		for (int i = 0; i < ratings.length; i++) {
			Map<String, Integer> moviesRatings = userMovieMap.getOrDefault(ratings[i][0],
					new HashMap<String, Integer>());
			moviesRatings.put(ratings[i][1], Integer.parseInt(ratings[i][2]));
			userMovieMap.put(ratings[i][0], moviesRatings);
		}
		// System.out.println("map size >>" + userMovieMap.size());
		List<String> result = new ArrayList<>();

		Map<String, Integer> moviesRatings = userMovieMap.get(userName);
		for (String person : userMovieMap.keySet()) {
			if (person.equals(userName))
				continue;

			Map<String, Integer> personMoviesRatings = userMovieMap.get(person);

			Map<String, Integer> commonMovieRatings = new HashMap<>();
			Map<String, Integer> notCommonMovieRatings = new HashMap<>();

			for (String movieName : personMoviesRatings.keySet()) {
				if (moviesRatings.containsKey(movieName) && personMoviesRatings.get(movieName) >= 4
						&& moviesRatings.get(movieName) >= 4)
					commonMovieRatings.put(movieName, personMoviesRatings.get(movieName));
				else
					notCommonMovieRatings.put(movieName, personMoviesRatings.get(movieName));
			}
			for (String movieName : notCommonMovieRatings.keySet()) {
				if (!moviesRatings.containsKey(movieName) && !commonMovieRatings.isEmpty()
						&& notCommonMovieRatings.get(movieName) >= 4) {
					result.add(movieName);
				}
			}

		}

		return result;
	}
}
