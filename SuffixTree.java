/*
	
	@author: Ganesh Joshi
	@File :- SuffixTree
	
	@problem : search String in given String
	
	Construction of suffix tree takes O(n)  where n is number of characters in original string
	Search will take O(n) where n is number of search string

 */
package chapter9.sorting.searching;

import java.util.ArrayList;
import java.util.Hashtable;

class SuffNode {

	Hashtable<Character, SuffNode> table;
	ArrayList<Integer> indexptr;

	public SuffNode() {
		table = new Hashtable<Character, SuffNode>();
		indexptr = new ArrayList<Integer>();
	}

	public ArrayList<Integer> getIndex() {
		return this.indexptr;
	}

	public void insertSuffix(String s, int index) {

		if (s.length() != 0) {

			Character x = s.charAt(0);
			// First check if this character exist in the hash table if it
			// doesn't contain just add it
			if (!this.table.containsKey(s.charAt(0))) {

				// doesn't contain
				this.table.put(x, new SuffNode());

			}

			// recursively call
			this.table.get(x).indexptr.add(index);
			this.table.get(x).insertSuffix(s.substring(1), index);

		} else
			return;

	}

}

public class SuffixTree {

	private SuffNode root;

	public SuffixTree() {
		root = new SuffNode();
	}

	private void gen(String string, int index) {

		root.insertSuffix(string, index);

	}

	public void search(String x) {

		SuffNode temp = root;

		ArrayList<Integer> foundindices = null;

		for (int i = 0; i < x.length(); i++) {

			if (temp.table.containsKey(x.charAt(i))) {

				foundindices = temp.table.get(x.charAt(i)).getIndex();
				temp = temp.table.get(x.charAt(i));

			}
		}

		if (!foundindices.isEmpty()) {
			System.out.println("String found ");
			for (Integer m : foundindices) {
				System.out.println("at index" + (m));
			}
		}

	}

	public static void main(String[] args) {

		// create new object of the suffix
		SuffixTree sfxtree = new SuffixTree();
		String s = "geeksforgeeks.org";
		int len = s.length();
		for (int i = len - 1; i >= 0; i--) {
			sfxtree.gen(s.substring(i, len), i);

		}

		sfxtree.search("geek");

	}

}
