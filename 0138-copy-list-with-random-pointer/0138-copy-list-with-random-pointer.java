/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
       if (head == null) {
            return null;
        }

        // Step 1: Duplicate nodes and insert them into the original list
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // Step 2: Update random pointers in the copied nodes
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // Step 3: Separate the original and copied lists
        cur = head;
        Node newHead = head.next;
        Node copy = newHead;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;

            if (copy.next != null) {
                copy.next = copy.next.next;
                copy = copy.next;
            }
        }

        return newHead;
    }
}