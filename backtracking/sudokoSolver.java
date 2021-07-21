class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length==0){
            return;
        }
        solve(board);
    }
    public static boolean solve(char[][]board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    for(char c='1'; c<='9'; c++){
                        if(isValid(board, i, j,c)){
                            board[i][j] = c;
                            if(solve(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][]board, int r, int c, char ch){
        for(int i=r, j=0; j<=8; j++){
            if(board[i][j]==ch){
                return false;
            }
        }
        for(int i=0, j=c; i<=8; i++){
            if(board[i][j]==ch){
                return false;
            }
        }
        int tr = (r/3)*3, tc = (c/3)*3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[tr+i][tc+j]==ch){
                    return false;
                }
            }
        }
        return true;
    }
}