import java.util.Arrays;
import java.util.List;

import trie.Trie;
import trie.TrieUsingArray;
import trie.TrieUsingHashMap;

public class Runner {
	
	public static void main(String[] args) {
		
		Trie trie 
//		= new TrieUsingArray();
		= new TrieUsingHashMap();
		
		String[] words = {"dog", "doggy", "deer", "deal"};
		
		for(String word : words) {
			trie.add(word);
		}
		
		System.out.println("Words in Trie: " + Arrays.toString(words));
		
		String prefix = "dog";
		
		List<String> matchingWords = trie.getMatchingWords(prefix);
		
		System.out.println("Words matching prefix: " + prefix + " = " + matchingWords);
		
		prefix = "de";
		
		matchingWords = trie.getMatchingWords(prefix);
		
		System.out.println("Words matching prefix: " + prefix + " = " + matchingWords);
		
		trie.add("dear");
		
		System.out.println("Word: \"dear\" newly added to Trie");
		
		matchingWords = trie.getMatchingWords(prefix);
		
		System.out.println("Words matching prefix: " + prefix + " = " + matchingWords);
	}
}
