/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)return null;
        
        int n = countNode(head);
        k = k % n;
        if(k == 0)return head;
        int count = n - k;
        ListNode newHead = head;
        ListNode newTail = head;
        ListNode oldTail = findTail(head);
        while(count > 0){
            count--;
            newTail = newHead;
            newHead = newHead.next;
        }
        oldTail.next = head;
        newTail.next = null;
        return newHead;
    }
    
    private int countNode(ListNode head){
        ListNode node = head;
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }
    
    private ListNode findTail(ListNode head){
        ListNode tail = head;
        if(head == null)return null;
        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
    }
}