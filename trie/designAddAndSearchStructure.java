
class designAddAndSearchStructure {
    public class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
    }

    private Node root = null;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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
        return find(root, word, 0);
    }

    public boolean find(Node node, String word, int idx) {

        if (idx == word.length()) {
            return node.isEnd;
        }

        char ch = word.charAt(idx);

        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                Node child = node.children[i];

                if (child != null && find(child, word, idx + 1)) {
                    return true;
                }
            }
        } else if (node.children[ch - 'a'] != null) {
            return find(node.children[ch - 'a'], word, idx + 1);
        }

        return false;
    }
}
