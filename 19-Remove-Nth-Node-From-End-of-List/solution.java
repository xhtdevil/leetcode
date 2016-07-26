/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = length(head);
        ListNode node = head;
        int m = length - n;
        if(m == 0){return node.next;}
        while(m != 1){
            node = node.next;
            m--;
        }
        node.next = node.next.next;
        return head;
    }
    
    
    
    private int length(ListNode root){
        int length = 0;
        while(root != null){
            root = root.next;
            length++;
        }
        return length;
    }
}