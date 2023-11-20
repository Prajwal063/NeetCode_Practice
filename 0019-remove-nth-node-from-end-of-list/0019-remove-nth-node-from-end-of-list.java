/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;
        
        for(int i = 0; i<n+1; i++){
            fast = fast.next;
        }
        
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        
        return start.next;
    }
}


//LOGIC-
//1>we keep two pointer slow and fast(both move one at a time)both initially at start of list(at the dummy node)
//2>we move the fast to n+1 places away from the slow pointer
//3>we then traverse the list we check if fast is equal to null or not,if it is null we know that the slow pointer      has reached just one node before the node we need to delete!
//4>then we slow.next=slow.next.next!



//suppose:
//1->2->3->4->5->6
//n=2
//make a dummy node with val=0;(we call this start)
//so now our list looks like
//0->1->2->3->4->5->6
//slow ,start , fast all are pointing to 0 valued node!
//after executing step 2 of our algorithm we have
//slow and start still at 0
//but fast is at node with val 3;
//now we execute step 3
//different positions of slow and fast is shown below!
//[slow=1,fast=4]->[slow=2,fast=5]->[slow=3,fast=6]->[slow=4,fast=null]
//wow!!slow have reached one node before out target node
//now just do slow.next=slow.next.next;