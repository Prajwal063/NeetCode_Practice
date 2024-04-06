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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode current = head;
        int count = 0;
        
        //Keep iterating until count == k and current != null
        while(current!=null && count!=k){
            current = current.next;
            count++;
        }
        
        if(count == k){
            current = reverseKGroup(current, k);
            head = reverse(head, current, count);
        }
        return head;
    }
    
    public ListNode reverse(ListNode head, ListNode tail, int count){
        ListNode previous = tail;
        ListNode current = head;
        
        while(count-- > 0){
            
            ListNode next = current.next;          // next - next head in direct part
            current.next = previous;            // preappending "direct" head to the reversed list
            previous = current;                 // move head of reversed part to a new node
            current = next;                     // move "direct" head to the next node in direct part
        }
        return previous;
    }
}