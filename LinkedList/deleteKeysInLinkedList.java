class GfG
{
    public static Node deleteAllOccurances(Node head, int x)
    {
        // Your code here
        if(head==null){
            return head;
        }
        Node temp = head;
        Node prev = head;
        
        while(temp!=null && temp.data==x){
            head = temp.next;
            temp = head;
        }
        while(temp!=null){
            while(temp!=null && temp.data!=x){
                prev = temp;
                temp = temp.next;
            }
            if(temp==null){
                return head;
            }
            prev.next = temp.next;
            temp = prev.next;
        }
        return head;
    }
}