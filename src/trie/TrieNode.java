package trie;

/**
 * Implementation of Trie Data Structure
 * 
 * @author https://github.com/abhishek-bits
 */
public class TrieNode {
	
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
