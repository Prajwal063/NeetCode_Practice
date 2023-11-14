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
        
        //THIS PROBLEM IS THE COMBINATION OF "REVERSE LIST" AND "MERGE TWO LISTS" PROBLEMS
        
        if(head == null || head.next == null)   
            return;
        
        //head of first half list
        ListNode list1 = head;
        //tail of first half list
        ListNode prev = null;
        //head of second half list
        ListNode slow = head;
        //tail of second half list
        ListNode fast = head;
        
        //split the list to half, by doing this we reach at the middle of the list
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //when we reach middle node, then change middle_node.next (i.e prev.next here) to null
        prev.next = null;
        
        //reverse the second half of the list
        ListNode list2 = reverse(slow);
        
        //then merge the tow half lists
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
            //stores next node of each list list1 and list2
            ListNode list1_next = list1.next;
            ListNode list2_next = list2.next;
            
            //changes the list1.next to list2
            list1.next = list2;
            
            //if no next node in list1 exists then break
            if(list1_next == null){
                break;
            }
            
            //changes the list2.next to list1, same as line 66 but for list 2
            list2.next = list1_next;
            
            //chain will be like, list1 -> list2 -> list1 -> list2 ...
            
            //keep incrementing the next nodes
            list1 = list1_next;
            list2 = list2_next;
        }
    }
}

//ALGORITHM:
//Consider List given here   as   => List = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null
//                                          ^
//                                head, slow, fast, prev



//From line 23 to 33 list will be => List = 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null  
//                                          ^              ^    ^              ^
//                                         head           prev slow           fast 



//On line 35 list will be   as    => List = 1 -> 2 -> 3 -> 4 -> null       5 -> 6 -> 7 -> 8 -> null 
//                                          ^              ^               ^              ^
//                                         head           prev            slow           fast 




//On line 41 list after reversed  => List1 = 1 -> 2 -> 3 -> 4 -> null       
//                                           ^              ^             
//                                          head           prev    

//reverse the second half of the list
//On line 41 list after reversed  => List2 = 8 -> 7 -> 6 -> 5 -> null 
//                                           ^              ^
//                                          slow           fast


//merge the two lists by taking value of each list alternatively
//On line 41 list after merged as => List = 1 -> 8 -> 2 -> 7 -> 3 -> 6 -> 4 -> 5 -> null      
//                                          ^              ^    ^              ^            
//                                         head           prev slow           fast            

















