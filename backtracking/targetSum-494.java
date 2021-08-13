
// naive recursion

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return sol(nums, 0, 0, target);
    }
    
    
    public int sol(int[] nums, int i, int sum, int S){
                if(i==nums.length){
                    if(S == sum)
                        return 1;
                    return 0;
                }
                //Positive
        
                int pos=sol(nums,i+1,sum+nums[i],S);
        
                //Negative
        
                int neg=sol(nums,i+1,sum-nums[i],S);
                
                return pos + neg;
            }
}