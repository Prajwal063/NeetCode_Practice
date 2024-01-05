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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        
        ArrayList<Integer> al = new ArrayList();
        
        for(ListNode list: lists){
            while(list!=null){
                al.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(al);
        
        for(int v: al){
            temp.next = new ListNode(v);
            temp = temp.next;
        }
        return head.next;
        
    }
}