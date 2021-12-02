import java.util.*;
 
 class Solution {
     
    public class Node{
        Node[] children;
        boolean isEnd;
        int freq;
        
        Node(){
            this.children = new Node[26];
            this.isEnd = false;
            this.freq = 0;
        }
    }

    private int[] xdir = { -1, 0, 1, 0 };
    private int[] ydir = { 0, -1, 0, 1 };

    public void insert(String word, Node root) {

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (root.children[ch - 'a'] == null) {
                root.children[ch - 'a'] = new Node();
            }

            root = root.children[ch - 'a'];
            root.freq++;
        }
        root.isEnd = true;
    }

    public List<String> findWords(char[][] board, String[] words) {

        Node root = new Node();
        for (String word : words) {
            insert(word, root);
        }
        boolean[][] vis = new boolean[board.length][board[0].length];

        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                StringBuilder str = new StringBuilder();
                travelAndAdd(board, i, j, root, vis, res, str);
            }
        }
        return res;
    }

    public int travelAndAdd(char[][] board, int i, int j, Node root, boolean[][] vis, List<String> res,
            StringBuilder str) {

        char ch = board[i][j];

        if (root.children[ch - 'a'] == null) {
            return 0;
        }

        root = root.children[ch - 'a'];

        if (root.freq == 0) {
            return 0;
        }

        int count = 0;
        vis[i][j] = true;
        str.append(ch);

        if (root.isEnd == true) {
            res.add(str.toString());
            root.isEnd = false;
            count = 1;
        }

        for (int d = 0; d < 4; d++) {
            int r = i + xdir[d];
            int c = j + ydir[d];

            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && vis[r][c] == false) {
                count += travelAndAdd(board, r, c, root, vis, res, str);
            }

        }
        str.deleteCharAt(str.length() - 1);
        vis[i][j] = false;
        root.freq -= count;
        return count;
    }
}
