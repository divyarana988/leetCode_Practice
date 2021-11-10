class Solution
{

   // Should rearrange given linked list such that all even
   // positioned Nodes are before odd positioned.
   // Returns nothing
    void rearrangeEvenOdd(Node head)
    {
        if(head==null){
            return;
        }
        Node odd = head;
        Node even = head.next;
        Node evenFirst = even;
        
        while(true){
            if(odd==null || even==null || even.next==null){
                odd.next = evenFirst;
                break;
            }
            odd.next = even.next;
            odd = even.next;
            
            if(odd.next == null){
                even.next = null;
                odd.next = evenFirst;
                break;
            }
            even.next = odd.next;
            even = odd.next;
            
        }
    }
}