/**
* author: Javed Attar
*/
package learn.javed.algorithms.tree;

import java.util.Map;
import java.util.TreeMap;

public class TrieTree {

	TrieNode root;

	public TrieTree() {
		root = new TrieNode();
	}

	public static void main(String[] args) {
		TrieTree tree = new TrieTree();
		tree.insert("abc");
		tree.insert("abgl");
		tree.insert("abcd");
		System.out.println(" Search abc, Expected true, Actual " + tree.search("abc"));
		System.out.println(" Search abd, Expected false, Actual " + tree.search("abd"));
		tree.insert("lmn");
		tree.insert("opq");
		tree.insert("cdf");
		tree.insert("lmnop");
		System.out.println(" Search opq, Expected true, Actual " + tree.search("opq"));
		System.out.println(" Prefix Search lm, Expected true, Actual " + tree.prefSearch("lm"));
		System.out.println(" Prefix Search df, Expected false, Actual " + tree.prefSearch("df"));
		System.out.println(" Prefix Search abce, Expected false, Actual " + tree.prefSearch("abce"));
		System.out.println(" Delete abc");
		tree.delete("abc");
		System.out.println(" Search abc, Expected false, Actual " + tree.search("abc"));
		System.out.println(" Search abcd, Expected true, Actual " + tree.search("abcd"));
		System.out.println(" Delete abgl");
		tree.delete("abgl");
		System.out.println(" Search abgl, Expected false, Actual " + tree.search("abgl"));
		tree.delete("abd");

	}

	public class TrieNode {
		// HashMap is used to make Trie generic to support call unicode characters
		// If only upper case / lower case characters are required then array of 26 should suffice
		Map<Character, TrieNode> children;
		// Marks end of word, default is false
		boolean isEndOfWord;

		public TrieNode() {
			children = new TreeMap<>();
		}
	}

	// Iterative method to insert word into trie tree
	private void insert(String word) {
		// Have a local reference to keep track of current node and initialize with root
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = current.children.get(c);
			// if node doesn't exist create a new node and add char/node into map
			if (node == null) {
				node = new TrieNode();
				current.children.put(c, node);
			}
			current = node;
		}
		// At end of word length set node end of word
		current.isEndOfWord = true;
	}

	// Search iteratively
	private boolean search(String word) {
		// Have a local reference to keep track of current node and initialize with root
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = current.children.get(c);
			// if node doesn't exist immediately return
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current.isEndOfWord;
	}

	// prefix search iteratively
	private boolean prefSearch(String word) {
		// Have a local reference to keep track of current node and initialize with root
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = current.children.get(c);
			// if node doesn't exist immediately return
			if (node == null) {
				return false;
			}
			current = node;
		}
		return current != null;
	}

	// Delete word from Trie
	// Since we have to reach end of word in tree and then backtrack to remove nodes with no children
	// using recursive delete function
	public void delete(String word) {
		delete(root, word, 0);
	}

	private boolean delete(TrieNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.isEndOfWord) {
				return false;
			}
			current.isEndOfWord = false;
			return current.children.size() == 0;
		}
		char c = word.charAt(index);
		TrieNode node = current.children.get(c);

		if (node == null)
			return false;

		boolean shouldDeleteNode = delete(node, word, index + 1);
		if (shouldDeleteNode) {
			// Remove node
			current.children.remove(c);
			// Check if after removing node if still there are children left
			return current.children.size() == 0;
		}
		return false;

	}
}
