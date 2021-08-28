 public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        HashSet<String> set = new HashSet<>();
        StringBuilder psf;

        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){

                if(grid[r][c]==1){
                    psf= new StringBuilder("X");
                    helper(grid, r, c, psf);
                    set.add(psf.toString());
                }
            }
        }
        return set.size();
    }
    public void helper(int[][]grid, int r, int c, StringBuilder psf){
        grid[r][c] = 2;

        if(r-1>=0 && grid[r-1][c]==1){
            psf.append("N");
            helper(grid, r-1, c, psf);
        }
        if(c+1<grid[0].length && grid[r][c+1]==1){
            psf.append("E");
            helper(grid, r, c+1, psf);
        }
        if(r+1<grid.length && grid[r+1][c]==1){
            psf.append("S");
            helper(grid, r+1, c, psf);
        }
        if(c-1>=0 && grid[r][c-1]==1){
            psf.append("N");
            helper(grid, r, c-1, psf);
        }
        psf.append("Z");
    }