public class implementationOfTrie {
   
        public class Node {
            Node[] children;
            boolean isEnd;

            Node() {
                this.children = new Node[26];
                this.isEnd = false;
            }

        }

        private Node root = null;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            Node ptr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (ptr.children[ch - 'a'] == null) {
                    Node newNode = new Node();
                    ptr.children[ch - 'a'] = newNode;
                }
                ptr = ptr.children[ch - 'a'];
            }
            ptr.isEnd = true;
        }

        public boolean search(String word) {
            Node ptr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (ptr.children[ch - 'a'] == null) {
                    return false;
                }
                ptr = ptr.children[ch - 'a'];
            }
            return ptr.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node ptr = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                if (ptr.children[ch - 'a'] == null) {
                    return false;
                }
                ptr = ptr.children[ch - 'a'];
            }
            return true;
        }
}
