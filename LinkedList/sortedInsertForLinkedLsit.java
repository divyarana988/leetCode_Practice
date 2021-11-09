public static Node sortedInsert(Node head,int data)
         {
            //add code here.
            Node node = new Node(data);
            Node curr = head;
            
            if(curr==null){
                node.next = node;
                return node;
            }
            else if(curr.data >= node.data){
                while(curr.next!=head){
                    curr = curr.next;
                }
                curr.next = node;
                node.next = head;
                return node;
            }
            else{
                while(curr.next!=head && curr.next.data<node.data){
                    curr = curr.next;
                }
                node.next = curr.next;
                curr.next = node;
                return head;
            }
            
         }