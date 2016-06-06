/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null|| head.next == null){return head;}
        ListNode next = null;
        ListNode node = head;
        head = head.next;
        while(node != null && node.next != null){
            next = node.next.next;
            node.next.next = node;
            if(next != null && next.next != null){
                node.next = next.next;
            }else if(next != null && next.next == null){
                node.next = next;
            }else{node.next = null;} 
            node = next;
        }
        return head;
    }
}