class Solution {
    
   public static int [][] dir = {{0,1}, {0, -1}, {1,0}, {-1,0}};
    
    public int[][] findFarmland(int[][] land) {
        int r = land.length;
        int c = land[0].length;
        List<int[]> ans = new ArrayList<>();
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                
                if(land[i][j]==1){
                    int[] arr = new int[]{i, j};
                    int[] last = new int[]{i,j};
                    
                    Queue<int[]> que = new ArrayDeque<>();
                    que.add(new int[]{i, j});
                    land[i][j] = 2;
                    while(que.size()>0){
                        int[] rem = que.remove();
                        
                        for(int d=0; d<4; d++){
                            int rd = rem[0] + dir[d][0];
                            int cd = rem[1]+ dir[d][1];
                            
                            if(rd>=0 && cd>=0 && rd<land.length && cd<land[0].length && land[rd][cd]==1){
                            land[rd][cd] = 2;
                            que.add(new int[]{rd, cd});
                            last[0] = rd;
                            last[1] = cd;  
                        }
                        
                        }                 
                    }
                   ans.add(new int[]{arr[0], arr[1], last[0], last[1]});
                }                  
            }
        }
        return ans.toArray(new int[0][]);
    }
}