import java.util.HashMap;
import java.util.Map;

public class Trie {
	private Map<Character,Trie> childrens;
	private boolean isEndOfTheWord;
    /** Initialize your data structure here. */
    public Trie() {
    	childrens = new HashMap<>();
    	isEndOfTheWord = false;
    }
    
    public void setEndOfTheWord(boolean isEndOfTheWord){
    	this.isEndOfTheWord = isEndOfTheWord;
    }
    
    public boolean isEndOfTheWord(){
    	return isEndOfTheWord;
    }
    
    public void addChildren(Character a){
    	if(!childrens.containsKey(a)){
    		childrens.put(a, new Trie());
    	}
    }
    
    public Trie getAssociatedTrieNode(Character a){
    	return childrens.get(a);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
     Trie current = this;
     for(int i =0; i<word.length();i++){
    	 Trie node = current.childrens.get(word.charAt(i));
    	 if(node==null){
    		  node = new Trie();
    		 current.childrens.put(word.charAt(i),node);
    	 }
    	 current = node;
     }
     current.setEndOfTheWord(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	Trie current = this;
    	for(int i=0;i<word.length();i++){
    		Trie node = current.childrens.get(word.charAt(i));
    		if(node==null){
    			return false;
    		}
    		current=node;
    	}
		return current.isEndOfTheWord();
        
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	Trie current = this;
    	for(int i=0;i<prefix.length();i++){
    		Trie node = current.childrens.get(prefix.charAt(i));
    		if(node==null){
    			return false;
    		}
    		current=node;
    	}
		return true;
    }
    
//    public void delete(String word){
//    	Trie current = this;
//    	Trie lastNode = null;
//    	for(int i=0;i<word.length();i++){
//    		Trie node = current.childrens.get(word.charAt(i));
//    		if(node==null){
//    			return;
//    		}
//    		lastNode = current;
//    		current=node;
//    	}
//    	if(current.childrens.isEmpty()){
//    		lastNode.r
//    	}
//    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */