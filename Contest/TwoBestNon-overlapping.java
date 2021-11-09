class Solution {
    public int maxTwoEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        
        PriorityQueue<Pair> que = new PriorityQueue<Pair>();
        
        int maxVal = 0;
        int res = 0;
        
        for(int[] e : events){
            int startTime = e[0];
            while(que.size()>0){
                Pair rem = que.peek();
                if(rem.end >= startTime)
                    break;
                Pair removed = que.remove();
                maxVal = Math.max(maxVal, removed.val);
            }
            res = Math.max(res, e[2]+maxVal);
            que.add(new Pair(e[1], e[2]));
        }
        return res;
    }
    
    public class Pair implements Comparable <Pair>{
        int end ;
        int val;
        
        public Pair(int end, int val){
            this.end = end;
            this.val = val;
        }
        public int compareTo(Pair o){
            return this.end-o.end;
        }
    }
}

