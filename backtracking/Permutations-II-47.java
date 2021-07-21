class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0)
            return list;
        boolean [] used = new boolean[nums.length];
        Arrays.sort(nums);
        sol(nums, used, new ArrayList<>(), list);
        return list;
    }
    
    public void sol(int[]nums, boolean[]used, List<Integer> temp, List<List<Integer>> list){
        if(temp.size()==nums.length){
            list.add(new ArrayList<>(temp));
        }else{
            for(int i=0; i<nums.length; i++){
                if(used[i])
                    continue;
                if(i>0 && nums[i-1]==nums[i] && !used[i-1])
                    continue;
                used[i] = true;
                temp.add(nums[i]);
                sol(nums, used, temp, list);
                used[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}

