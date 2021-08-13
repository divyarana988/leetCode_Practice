class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        sol(res, new ArrayList<>(), n, k, 1, 0);
        return res;
    }
    
    public static void sol(List<List<Integer>> res, List<Integer> temp, int n, int k, int start, int sum){
        if(temp.size() == k && sum == n){
                res.add(new ArrayList<>(temp));
                return;
        }
        for(int i=start; i<=9; i++ ){
            temp.add(i);
            sol(res, temp, n, k, i+1, sum+i);
            temp.remove(temp.size()-1);
        }
    }
}