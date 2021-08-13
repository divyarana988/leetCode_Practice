class Solution {
       public List<List<String>> solveNQueens(int n) {
           
           char[][]board = new char[n][n];
           for(int i=0; i<n; i++){
               for(int j=0; j<n; j++){
                   board[i][j] = '.';
               }
           }
            List<List<String>> res = new ArrayList<List<String>>();
            boolean[] rows = new boolean[n];     
            boolean[] d1 = new boolean[2 * n-1];   
            boolean[] d2 = new boolean[2 * n-1];  
            dfs(0, board, res, rows, d1, d2);
            return res;
    }
    
    public static void dfs(int col, char[][] board, List<List<String>> res, boolean rows[], boolean d1[], boolean d2[]) {
        
        int n = board.length;
        
        if(col == board.length) {
            res.add(construct(board));
            return;
        }
        
        for(int row = 0; row < board.length; row++) {
            int id1 = col - row + n-1;
            int id2 = col + row;
            if(rows[row] || d1[id1] || d2[id2]) continue;
            board[row][col] = 'Q';
            rows[row] = true; d1[id1] = true; d2[id2] = true;
            dfs(col + 1, board, res, rows, d1, d2);
            board[row][col] = '.';
            rows[row] = false; d1[id1] = false; d2[id2] = false;
        }
    }
    
     public static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}