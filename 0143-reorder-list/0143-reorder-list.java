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
    public void reorderList(ListNode head) {
        
        if(head == null || head.next == null)   
            return;
        
        ListNode list1 = head;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode list2 = reverse(slow);
        
        merge(list1, list2);
    }
    
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    public void merge(ListNode list1, ListNode list2){
        while(list1 != null){
            ListNode list1_next = list1.next;
            ListNode list2_next = list2.next;
            list1.next = list2;
            
            if(list1_next == null){
                return;
            }
            
            list2.next = list1_next;
            
            list1 = list1_next;
            list2 = list2_next;
        }
            
        
    }
    
}