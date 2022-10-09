package trie;

import java.util.List;

/**
 * Trie interface specifying the functionalities that any implementing class should provide.
 * 
 * @author https://github.com/abhishek-bits
 * 
 */
public interface Trie {

	/**
	 * Inserts the given word into the Trie
	 * @param word
	 */
	public void add(String word);
	
	/**
	 * Returns a list of words starting from the given prefix
	 * @param prefix
	 * @return
	 */
	public List<String> getMatchingWords(String prefix);
}
