class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        sol(res, new ArrayList<>(), n, k, 1);
        return res;
    }
    public static void sol(List<List<Integer>> res, List<Integer> temp, int n, int k, int start){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start; i<=n; i++){
            temp.add(i);
            sol(res, temp, n, k, i+1);
            temp.remove(temp.size()-1);
        }
    }
}