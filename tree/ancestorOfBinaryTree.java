class Solution
{
    
    public static boolean sol(Node root, int tar, ArrayList<Integer> res){
        if(root == null){
            return false;
        }
        if(root.data == tar){
            return true;
        }
        if(sol(root.left, tar, res) || sol(root.right, tar, res)){
            res.add(root.data);
            return true;
        }
        return false;
    }
    
    public static ArrayList<Integer> Ancestors(Node root, int target)
    {
        ArrayList<Integer> res = new ArrayList<>();
        sol(root, target, res);
        return res;
    }
}