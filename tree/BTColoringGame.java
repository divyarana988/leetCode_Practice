class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
	if(root == null) return false;

	if(root.val == x){
		int left = count(root.left);
		int right = count(root.right);
		int parent = n - (left+right+1);

		return parent > (left + right)  || left > (parent + right) || right> (parent + left);
	}

	return btreeGameWinningMove(root.left, n, x) || btreeGameWinningMove(root.right, n, x);
}

private int count(TreeNode node){
	if(node == null) return 0;
	return count(node.left) + count(node.right) + 1;
}
}