package Linked;

public class LinkedList {
    public static Node FirstAdd(Node head,int e) {
        Node cur= new Node(e);
        if(head == null) {
            head = cur;
        } else {
            cur.next = head;
            head = cur;
        }
        return head;

    }
    public static Node Last(Node head,int e) {
        return head;

    }

}
