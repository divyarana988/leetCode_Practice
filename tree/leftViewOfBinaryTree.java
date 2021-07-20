public static ArrayList<Integer> leftView(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<>();
        left(root, 0, list);
        return list;

    }

    public static void left(TreeNode node, int level, ArrayList<Integer> list){
        if(node == null)
            return;
        if(level == list.size())
            list.add(node.val);
        
        left(node.left, level+1, list);
        left(node.right, level+1, list);
    }
