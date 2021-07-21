class Solution {


public List<List<Integer>> combinationSum(int[] cand, int t) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(cand);
        sol(0 , cand, t, new ArrayList<>() , res);
        return res;
    }
    
    public static void sol(int i, int[]arr,int t, List<Integer> temp, List<List<Integer>> res){
        if(i==arr.length){
            if(t==0){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        
        if(arr[i]<=t){
            temp.add(arr[i]);
            sol(i, arr, t-arr[i], temp, res );
            temp.remove(temp.size()-1);
        }
        sol(i+1, arr, t, temp, res);
    }

}





