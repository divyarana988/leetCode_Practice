public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        // write your code here
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] vis = new boolean[n][m];

        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(start[0], start[1]));
        vis[start[0]][start[1]] = true;

        int[][] dir = {{-1, 0}, {0, 1}, {1,0}, {0,-1}};

        
        while(que.size()!=0){
            Pair rem = que.remove();

            if(rem.r==dest[0] && rem.c==dest[1]){
                return true;
            }


            for(int d=0; d<4; d++){
                int newR = rem.r;
                int newC = rem.c;

                while(newR>=0 && newR<n && newC>=0 && newC<n && maze[newR][newC]==0){
                    newR += dir[d][0];
                    newC += dir[d][1];
                }

                newR-=dir[d][0];
                newC-=dir[d][1];

                if(vis[newR][newC]==false){
                    vis[newR][newC] = true;
                    que.add(new Pair(newR, newC));
                }
            }
        }
        return false;
    }