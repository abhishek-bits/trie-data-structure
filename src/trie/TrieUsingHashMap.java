package trie;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of Trie Data Structure using HashMap
 * 
 * @author https://github.com/abhishek-bits
 * 
 */
public class TrieUsingHashMap implements Trie {

	private static class TrieNode {
		
		// tells if the string ends here or not
		boolean isEndingChar;
		
		// children are representing using
		// character -> TreeNode pairs
		Map<Character,TrieNode> children;
		
		public TrieNode() {
			isEndingChar = false;
			children = new HashMap<>();
		}
		
	}
	
	private TrieNode root;
	
	public TrieUsingHashMap() {
		root = new TrieNode();
	}
	
	@Override
	public void add(String word) {
		
		TrieNode curr = root;
		
		for(char c : word.toCharArray()) {
			
			// If this character doesn't exist in the Trie, add it.
			if(!curr.children.containsKey(c)) {
				curr.children.put(c, new TrieNode());
			}
			
			curr = curr.children.get(c);
		}
		
		// this word ends here, so we mark it.
		curr.isEndingChar = true;
	}

	@Override
	public List<String> getMatchingWords(String prefix) {
		
		List<String> res = new ArrayList<>();
		TrieNode par = root;
		
		// walk through the prefix first
		for(char c : prefix.toCharArray()) {
			par = par.children.get(c);
		}
		
		// first check if this prefix is itself an ending character
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
		
		for(Map.Entry<Character, TrieNode> entry : par.children.entrySet()) {
			
			char elem = entry.getKey();
			TrieNode child = entry.getValue();
			
			populateList(res, child, prefix + elem);
			
			if(child.isEndingChar) {
				res.add(prefix + elem);
			}
		}
		
	}

}
