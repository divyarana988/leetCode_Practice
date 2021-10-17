class Solution {
    private final static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;

        int maxArea = 0;

        // iterate through every grid in the current array
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                // in case the current grid is a land and is not visited yet
                if (grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, r, c));
                }
            }
        }

        return maxArea;
    }

    // NOTE: learn the way that how we use the return value of DFS
    private int dfs(int[][] grid, int r, int c) {
        // mark current grid as visited (2)
        grid[r][c] = 2;

        int currArea = 1;

        // try out each possible direction
        for (int d=0; d<4; d++) {
            int nr = r + dir[d][0], nc = c + dir[d][1];
            if(nr<0 || nc<0 || nr>=grid.length || nc>=grid[0].length || grid[nr][nc]!=1)
                continue;
            currArea += dfs(grid, nr, nc);
        }

        return currArea;
    }
}