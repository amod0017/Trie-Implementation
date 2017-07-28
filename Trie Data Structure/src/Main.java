public class Main {
	public static void main(String[] args) {
		Trie t = new Trie();
		t.insert("abcde");
		t.insert("abcd");
		System.out.println(t.search("abc"));
		System.out.println(t.startsWith("b"));
	}
}
