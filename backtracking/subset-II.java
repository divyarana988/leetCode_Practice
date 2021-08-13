class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans  = new ArrayList<>();
        find(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    
    public void find(int idx, int[]nums, List<Integer> temp, List<List<Integer>> ans){
        ans.add(new ArrayList<>(temp));
        for(int i =idx; i<nums.length; i++){
            if(i!=idx && nums[i]==nums[i-1])
                continue;
            temp.add(nums[i]);
            find(i+1, nums, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
}

