class Solution {
    public int numBusesToDestination(int[][] rou, int s, int t) {
        int n = rou.length;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<rou[i].length; j++){
                
                int busStopNo = rou[i][j];
                ArrayList<Integer> busNo = map.getOrDefault(busStopNo, new ArrayList<Integer>());
                busNo.add(i);
                map.put(busStopNo, busNo);
            }
        }
        LinkedList<Integer> que = new LinkedList<>();
        HashSet<Integer> busStopVis = new HashSet<>();
        HashSet<Integer> busVis = new HashSet<>();
        
        int level =0;
        que.addLast(s);
        busStopVis.add(s);
        
        while(que.size()>0){
            int size = que.size();
            while(size-->0){
                int rem = que.removeFirst();
                if(rem==t)
                    return level;
               ArrayList<Integer> buses = map.get(rem);
               for(int bus: buses){
                   if(busVis.contains(bus)==true)
                       continue;
                   int[] arr = rou[bus];
                   for(int busStop : arr){
                       if(busStopVis.contains(busStop)==true)
                           continue;
                       que.addLast(busStop);
                       busStopVis.add(busStop);
                   }
                   busVis.add(bus);
               }  
            }
            level++;
        }
        return -1;
    }
}