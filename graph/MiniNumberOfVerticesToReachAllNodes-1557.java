class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        
        List<Integer> res = new ArrayList<>();
        int [] find = new int[n];
        
        for(List<Integer> e : edges){
            find[e.get(1)] = 1;
        }
        for(int i=0; i<n; i++){
            if(find[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}
