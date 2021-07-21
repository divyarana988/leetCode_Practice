class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int t) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(num);
        sol(0, num, t, ans, new ArrayList<>());
        return ans;
        
    }
    public void sol(int idx, int[]arr, int t, List<List<Integer>> ans, List<Integer> temp){
        if(t==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i<arr.length; i++){
            if(i>idx && arr[i]==arr[i-1])
                continue;
            if(arr[i]>t)
                break;
            temp.add(arr[i]);
            sol(i+1, arr , t-arr[i], ans, temp);
            temp.remove(temp.size()-1);
        }
    }
}