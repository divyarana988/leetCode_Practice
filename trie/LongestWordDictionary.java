public class LongestWordDictionary {
        public class Node {
            Node[] children;
            boolean isEnd;

            Node() {
                this.children = new Node[26];
                this.isEnd = false;
            }
        }

        public String longestWord(String[] words) {
            Arrays.sort(words);
            String res = "";

            for (int i = 0; i < words.length; i++) {
                int count = insert(words[i]);

                if (count == words[i].length() - 1 && words[i].length() > res.length()) {
                    res = words[i];
                }
            }
            return res;
        }

        private Node root = new Node();

        public int insert(String word) {
            Node ptr = root;
            int count = 0;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (ptr.children[ch - 'a'] == null) {
                    Node newNode = new Node();
                    ptr.children[ch - 'a'] = newNode;
                }
                if (ptr.isEnd) {
                    count++;
                }

                ptr = ptr.children[ch - 'a'];

            }
            ptr.isEnd = true;
            return count;
        }

    } 

