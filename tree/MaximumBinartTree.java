class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }
    public static TreeNode construct(int[]arr, int s, int e){
        if(s>e){
            return null;
        }
        if(s==e){
            new TreeNode(arr[s]);
        }
        int idx = findMax(arr, s, e);
        TreeNode root = new TreeNode(arr[idx]);
        root.left = construct(arr, s, idx-1);
        root.right = construct(arr, idx+1, e);
        return root;
    }
    public static int findMax(int[]arr, int s, int e){
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i=s; i<=e; i++){
            if(arr[i]>max){
                max = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}