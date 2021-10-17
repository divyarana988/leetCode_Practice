class Solution {
    
    public int[][]dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        //One visited map for each ocean
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        Queue<Pair> pQueue = new LinkedList<>();
        Queue<Pair> aQueue = new LinkedList<>();
        for(int i=0; i<n; i++){ //Vertical border
            pQueue.offer(new Pair(i,0));
            aQueue.offer(new Pair(i,m-1));
            pacific[i][0] = true;
            atlantic[i][m-1] = true;
        }
        for(int i=0; i<m; i++){ //Horizontal border
            pQueue.offer(new Pair(0,i));
            aQueue.offer(new Pair(n-1,i));
            pacific[0][i] = true;
            atlantic[n-1][i] = true;
        }
        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(List.of(i,j));
            }
        }
        return res;
    }
    
    
    public void bfs(int[][]matrix, Queue<Pair> queue, boolean[][]visited){
        int n = matrix.length, m = matrix[0].length;
        while(!queue.isEmpty()){
            Pair cur = queue.poll();
            for(int[] d:dir){
                int x = cur.r+d[0];
                int y = cur.c+d[1];
                if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[cur.r][cur.c]){
                    continue;
                }
                visited[x][y] = true;
                queue.offer(new Pair(x,y));
            } 
        }
    }
    public class Pair{
        int r, c;
        Pair(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
