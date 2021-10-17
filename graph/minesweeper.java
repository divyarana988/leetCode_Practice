class Solution {
    int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 } };

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] != 'M' && board[click[0]][click[1]] != 'E') {
            return board;
        }
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        revealBoard(board, click[0], click[1]);
        return board;
    }
    
    private void revealBoard(char[][] board, int x, int y) {
    
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
            return;
        }
    
        int mines = getMinesCount(board, x, y);
    
        if (mines != 0) {
            board[x][y] = (char) (mines + '0');
            return;
        }

        board[x][y] = 'B';
        
        for (int[] d : dir) {
            revealBoard(board, x + d[0], y + d[1]);
        }        
    }
    
    private int getMinesCount(char[][] board, int x, int y) {
        int mines = 0;
        for (int[] d : dir) {
            int r = x + d[0];
            int c = y + d[1];
            if (r >= 0 && r < board.length && c >= 0 && c < board[0].length && board[r][c] == 'M') {
                mines++;
            }
        }
        return mines;
    }

}