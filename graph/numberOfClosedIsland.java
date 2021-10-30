class Solution {
    public int[][] dir = {{0,1}, {0, -1}, {1,0}, {-1, 0}};
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        
        for(int i=0; i<grid.length-1;i++){
          for(int j=0;j<grid[0].length-1;j++){
            
            if(grid[i][j]==0){
                  if(helper(grid,i,j))
                     count++;
            }    
          }
         }
      return count;
    }
                      
    public boolean helper(int[][] grid,int i,int j){    
        if(grid[i][j]==1)
            return true; 
    
        if(i ==grid.length-1 || i ==0 || j==0 ||j == grid[0].length-1)
            return false;
    
        grid[i][j]=1;
        
        boolean flag = true;
        if(!helper(grid,i-1,j))
            flag=false;
        
        if(!helper(grid,i,j+1))
            flag=false;
        
        if(!helper(grid,i+1,j))
            flag=false;
        
        if(!helper(grid,i,j-1))
            flag=false;
        
        return flag;
    }

}