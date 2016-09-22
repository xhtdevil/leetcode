/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)return;
        ListNode mid = findMid(head);
        ListNode rev = reverse(mid.next);
        mid.next = null;
        ListNode node = head;
        ListNode next, rev_next;
        while(node != null && rev != null){
            next = node.next;
            rev_next = rev.next;
            node.next = rev;
            rev.next = next;
            rev = rev_next;
            node = next;
            
        }
    }
    
    private ListNode findMid(ListNode head){
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null)return head;
        ListNode next = null, node = head;
        ListNode pre = null;
        while(node != null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
        
    }
}