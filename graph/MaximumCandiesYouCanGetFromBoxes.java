class Solution {
   public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
    int n = status.length; // count of boxes
    // indicate whether a box has been used (no candy)
    boolean[] usedBoxes = new boolean[n];
    // indicate whether we have found a box (since you can only get candy on the box you found)
    boolean[] boxFound = new boolean[n];
    
    Queue<Integer> q = new LinkedList<>();
    for (int v : initialBoxes) {
        q.add(v);
        boxFound[v] = true; // initial boxes
    }
    
    int candy = 0;
    while (!q.isEmpty()) {
        int cur = q.poll();
        if (status[cur] == 1 && !usedBoxes[cur]) { // not used and box open
            candy += candies[cur];
            usedBoxes[cur] = true;
            
            // all keys in that box
            for (int k : keys[cur]) {
                // if this box is already open and found before
                // it must have been added to the queue, so don't duplicate add it to the queue
                // this could happen since multiple boxes can contain dupe keys
                if (status[k] == 1 && boxFound[k]) continue;
                
                // just set that box status as 1 to indicate we can open it 
                status[k] = 1;
                // box was found and we have the key
                // here we also guard by !usedBoxes[k] to avoid to add duplicate box into queue
                if (boxFound[k] && !usedBoxes[k]) q.add(k);
            }
            
            // all contained boxes
            for (int k : containedBoxes[cur]) {
                boxFound[k] = true;
                q.add(k);
            }
        }
    }
    return candy;
}
}