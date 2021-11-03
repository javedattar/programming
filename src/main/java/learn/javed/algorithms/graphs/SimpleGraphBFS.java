/**
* author: Javed Attar
*/
package learn.javed.algorithms.graphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SimpleGraphBFS {

	public static void main(String[] args) {
		// Undirected Graph
		Map<String, List<String>> adjancencyList = new HashMap<>();
		adjancencyList.put("A", Arrays.asList("C", "P"));
		adjancencyList.put("C", Arrays.asList("D", "E"));
		adjancencyList.put("D", Arrays.asList("H", "I"));
		adjancencyList.put("H", Arrays.asList("I"));
		adjancencyList.put("I", Arrays.asList("B"));
		adjancencyList.put("P", Arrays.asList("X"));
		adjancencyList.put("X", Arrays.asList("B"));
		System.out.println("Num of hops from A to B >> " + findShortestPath(adjancencyList, "A", "B"));
		System.out.println("Num of hops from C to B >> " + findShortestPath(adjancencyList, "C", "B"));
		System.out.println("Num of hops from E to B >> " + findShortestPath(adjancencyList, "E", "B"));
	}

	private static int findShortestPath(Map<String, List<String>> adjancencyList, String source, String target) {
		Queue<String> processingQueue = new LinkedList<>();
		processingQueue.add("A");
		int numHops = -1, levelSize = processingQueue.size();
		boolean isFound = false;
		while (!processingQueue.isEmpty()) {
			String node = processingQueue.poll();
			levelSize--;
			if (isFound = target.equals(node)) {
				break;
			} else {
				processingQueue.addAll(adjancencyList.getOrDefault(node, Collections.EMPTY_LIST));
			}
			if (levelSize == 0 && !processingQueue.isEmpty()) {
				numHops++;
				levelSize = processingQueue.size();
			}
		}
		return isFound ? numHops : -1;
	}

}
