class Solution
{
    Node compute(Node head)
    {
        // your code here
        head = reverse(head);
        Node curr = head;
        Node maxN = head;
        Node temp;
        
        while(curr!=null && curr.next!=null){
            if(curr.next.data<maxN.data){
                temp = curr.next;
                curr.next = temp.next;
            }else{
                curr = curr.next;
                maxN = curr;
            }
        }
        head = reverse(head);
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