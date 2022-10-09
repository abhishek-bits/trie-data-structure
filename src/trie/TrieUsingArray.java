package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Trie Data Structure using Array
 * 
 * @author https://github.com/abhishek-bits
 */
public class TrieUsingArray implements Trie {

	private static class TrieNode {
		
		// tells if the string ends here or not
		boolean isEndingChar;
		
		// each item in the children array
		// is a link to another TrieNode(s).
		// [a-z] : [0-25]
		TrieNode[] children;
		
		public TrieNode() {
			isEndingChar = false;
			children = new TrieNode[26];
		}
		
	}
	
	private TrieNode root = null;
	
	public TrieUsingArray() {
		root = new TrieNode();
	}
	
	@Override
	public void add(String word) {
		
		TrieNode curr = root;
		
		for(char c : word.toCharArray()) {
			
			int idx = c - 'a';
			
			// If this character doesn't exist in trie, add it
			if(curr.children[idx] == null) {
				curr.children[idx] = new TrieNode();
			}
			
			curr = curr.children[idx];
		}
		
		// this word ends here, so we mark it.
		curr.isEndingChar = true;
	}
	
	@Override
	public List<String> getMatchingWords(String prefix) {
		
		List<String> res = new ArrayList<>();
		TrieNode par = root;
		
		for(char c : prefix.toCharArray()) {
			int idx = c - 'a';
			par = par.children[idx];
		}
		
		// first check if this prefix is itself an 
		if(par.isEndingChar) {
			res.add(prefix);
		}
		
		// Now, find out other words starting with this prefix
		populateList(res, par, prefix);
		
		return res;
	}
	
	/**
	 * Recursive method to populate the list of matching words
	 * from the given prefix string by traversing through the Trie.
	 * @param res
	 * @param par
	 * @param prefix
	 */
	private void populateList(List<String> res, TrieNode par, String prefix) {
		
		for(int i = 0; i < 26; i++) {
			
			TrieNode child = par.children[i];
			
			if(child != null) {
				
				char c = (char) (i + 'a');
				
				populateList(res, child, prefix + c);
				
				if(child.isEndingChar) {
					res.add(prefix + c);
				}
			}
		}
		
	}

}
