    int[][]  dir = {{-1, 0}, {0,1}, {1,0}, {0,-1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image; // same color -> no need to replace

        int m = image.length, n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        int oldColor = image[sr][sc];
        image[sr][sc] = newColor;
        while (q.size()>0) {
            int[] rem = q.remove();
            for (int d = 0; d < 4; d++) {
                int nr = rem[0] + dir[d][0];
                int nc = rem[1] + dir[d][1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || image[nr][nc] != oldColor) continue;
                image[nr][nc] = newColor; // also mean we marked it as visited!
                q.add(new int[]{nr, nc});
            }
        }
        return image;
    }