class Solution{
	public static Node zigZag(Node head){
        //add code here.
        Node curr = head;
        boolean flag = true;
        
        while(curr.next!=null){
            if(flag){
                if(curr.data>curr.next.data){
                    swap(curr, curr.next);
                }
            }else{
                if(curr.data<curr.next.data){
                    swap(curr, curr.next);
                }
            }
            curr = curr.next;
            flag=!flag;
        }
        return head;
    }
    public static void swap(Node a, Node b){
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
    }
}