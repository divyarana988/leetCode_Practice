class Solution {
    int dir[][] = {{-1,0}, {0,+1}, {+1,0},{0,-1}};
    public int numEnclaves(int[][] grid) {
        int count = 0;
        int []sizeOfIsland ;
        boolean[]connectedToBoundary;
        
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c]==1){
                    sizeOfIsland = new int[]{0};
                    connectedToBoundary = new boolean[]{false};
                    helper(grid, r, c, sizeOfIsland, connectedToBoundary);
                    if(!connectedToBoundary[0])
                        count+=sizeOfIsland[0];
                }
            }
        }
        return count;
    }
    
    public void helper(int[][]grid, int r, int c, int[]sizeOfIsland, boolean[]connectedToBoundary){
        
        if(r==0 || c==0 || r==grid.length-1 || c==grid[0].length-1)
            connectedToBoundary[0] = true;
        grid[r][c] = 2;
        sizeOfIsland[0]++;
        
        for(int d=0; d<4; d++){
            int rd = r+dir[d][0];
            int cd = c+dir[d][1];
            
            if(rd<0 || cd<0 || rd>=grid.length || cd>= grid[0].length || grid[rd][cd] != 1)
                continue;
            
            helper(grid, rd, cd, sizeOfIsland, connectedToBoundary);
        }
    }
}