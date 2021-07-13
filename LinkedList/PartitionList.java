public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode less = new ListNode(-1);
        ListNode great = new ListNode(-1);
        ListNode pl = less, pg = great, curr=head;
        
        while(curr!=null){
            if(curr.val<x){
                pl.next = curr;
                curr = curr.next;
                pl = pl.next;
            }else{
                pg.next = curr;
                curr = curr.next;
                pg = pg.next;
            }
        }
        pl.next = great.next;
        pg.next = null;
        head = less.next;
        return head;
    }