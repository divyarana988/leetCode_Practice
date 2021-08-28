class Solution {
    int dir[][] = {{-1,0}, {0,+1}, {+1,0},{0,-1}};
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                
                if(grid[r][c] == '1'){
                    count++;
                    helper(grid, r, c);
                }
                
            }
        }
        return count;
    }
    
     
    public void helper(char[][]grid, int r, int c){
        grid[r][c] = '2';
        
        for(int d=0; d<4; d++){
            int rd = r+dir[d][0];
            int cd = c+dir[d][1];
            
            if(rd<0 || cd<0 || rd>=grid.length || cd>=grid[0].length || grid[rd][cd]!='1')
                continue;
            helper(grid, rd, cd);
        }
    }
    
}