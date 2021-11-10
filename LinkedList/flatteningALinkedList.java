class GfG
{
    Node flatten(Node root)
    {
	// Your code here
	 if(root == null || root.next == null){
	     return root;
	 }
	 
	 root.next = flatten(root.next);
	 
	 root = merge(root, root.next);
	 
	 return root;
    }
    
    Node merge(Node l1, Node l2){
        
        Node res = new Node(-1);
        Node tail = res;
        
        if(l1==null && l2==null){
            return null;
        }
        
        while(l1!=null && l2!=null){
            
            if(l1.data<l2.data){
                tail.bottom = l1;
                l1 = l1.bottom;
            }else{
                tail.bottom = l2;
                l2 = l2.bottom;
            }
            
            tail = tail.bottom;
        }
        
        if(l1!=null){
            tail.bottom = l1;
        }else{
            tail.bottom = l2;
        }
        return res.bottom;
    }
    
    
}