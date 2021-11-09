class Sol
{
	public static Node findUnion(Node head1,Node head2)
	{
	    //Add your code here.
	    Node curr = null;
	    Node start = null;
	    
	    HashSet<Integer> hs = new HashSet<Integer>();
	    
	    while(head1!=null){
	        hs.add(head1.data);
	        head1 = head1.next;
	    }
	    while(head2!=null){
	        hs.add(head2.data);
	        head2 = head2.next;
	    }
	    for(Integer s : hs){
	        Node node = new Node(s);
	        if(start==null){
	            start = node;
	            curr = node;
	        }else{
	            curr.next = node;
	            curr = node;
	        }
	    }
	    return start;
	}
}