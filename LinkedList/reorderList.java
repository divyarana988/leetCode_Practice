class gfg {
    
    Node middle(Node head){
        Node fast =  head;
        Node slow = head;
        
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    Node reorderlist(Node head) {
        // Your code here
        
        if(head==null || head.next==null){
            return head;
        }
        
        Node mid = middle(head);
        Node fwd = mid.next;
        mid.next = null;
        fwd = reverse(fwd);
        Node p1 = head;
        Node p2 = fwd;
        Node tp1 = null;
        Node tp2 = null;
        
        while(p2!=null){
            tp1 = p1.next;
            tp2 = p2.next;
            
            p1.next = p2;
            p2.next = tp1;
            
            p1 = tp1;
            p2 = tp2;
        }
        
        return head;
        
    }
    
    Node reverse(Node head){
        
        Node curr = head;
        Node prev = null;
        
        while(curr!=null){
            Node fwd = curr.next;
            curr.next = prev;
            prev = curr;
            curr = fwd;
        }
        return prev;
        
    }
    
}