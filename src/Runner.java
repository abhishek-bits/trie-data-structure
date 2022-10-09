import java.util.List;

import trie.Trie;
import trie.TrieUsingArray;

public class Runner {
	
	public static void main(String[] args) {
		
		Trie trie = new TrieUsingArray();
		
		String[] words = {"dog", "doggy", "deer", "deal"};
		
		for(String word : words) {
			trie.add(word);
		}
		
		String prefix = "dog";
		
		List<String> matchingWords = trie.getMatchingWords(prefix);
		
		System.out.println(matchingWords);
		
		prefix = "de";
		
		matchingWords = trie.getMatchingWords(prefix);
		
		System.out.println(matchingWords);
		
		trie.add("dear");
		
		matchingWords = trie.getMatchingWords(prefix);
		
		System.out.println(matchingWords);
		
	}
}
