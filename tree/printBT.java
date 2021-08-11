class Solution {
    public List<List<String>> printTree(TreeNode root) {
    List<List<String>> result = new ArrayList<>();
    int row = getHight(root);
    int col = (int) Math.pow(2, row) - 1;
    List<String> ans = new ArrayList<>();
    for(int i = 0; i < col; i++)  ans.add("");
    for(int i = 0; i < row; i++)  result.add(new ArrayList<>(ans));
    populateResult(root, result, 0, row, 0, col - 1);
    return result;
}

public void populateResult(TreeNode root, List<List<String>> result, int curRow, int totalRow, int i, int j) {
    if(root == null || curRow == totalRow)  return;
    result.get(curRow).set((i + j) / 2, String.valueOf(root.val));
    populateResult(root.left, result, curRow + 1, totalRow, i, ((i + j) / 2) - 1);
    populateResult(root.right, result, curRow + 1, totalRow, ((i + j) / 2) + 1, j);
}

public int getHight(TreeNode root) {
    if(root == null)  return 0;
    return 1 + Math.max(getHight(root.left), getHight(root.right));
}
}