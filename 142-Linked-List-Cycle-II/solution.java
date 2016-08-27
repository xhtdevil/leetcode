/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode start = head;
        while(start != null){
            ListNode fast = start;
            ListNode slow = start;
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
                if(slow == fast){
                    if(slow == start)return start;
                    else{break;}
                }
            }
            start = start.next;
        }
        return null;
    }
}