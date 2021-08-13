class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        boolean[] rows = new boolean[n];     // columns   |
        boolean[] d1 = new boolean[2 * n-1];   // diagonals \
        boolean[] d2 = new boolean[2 * n-1];   // diagonals /
        backtracking(0, rows, d1, d2, n);
        return count;
    }
    
    public void backtracking(int col, boolean[] rows, boolean[] d1, boolean []d2, int n) {
        if(col == n) count++;

        for(int row = 0; row < n; row++) {
            int id1 = col - row + n-1;
            int id2 = col + row;
            if(rows[row] || d1[id1] || d2[id2]) continue;
            
            rows[row] = true; d1[id1] = true; d2[id2] = true;
            backtracking(col + 1, rows, d1, d2, n);
            rows[row] = false; d1[id1] = false; d2[id2] = false;
        }
    }
}