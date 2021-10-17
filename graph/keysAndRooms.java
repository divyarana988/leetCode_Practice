class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean [] vis= new boolean[rooms.size()];
        Arrays.fill(vis, false);
        LinkedList<Integer> que = new LinkedList<>();
        que.addLast(0);
        
        while(que.size()>0){
            int curr = que.removeFirst();
            vis[curr] = true;
            for(int k : rooms.get(curr)){
                if(!vis[k]){
                    que.addLast(k);
                }
            }
        }
        for(int i=0 ; i<rooms.size(); i++){
            if(vis[i]==false){
                return false;
            }
        }
        return true;
    }
}