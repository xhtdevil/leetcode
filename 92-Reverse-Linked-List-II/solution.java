/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head, node_prev = null;
        int count = 1;
        while(count < m){
            node_prev = node;
            node = node.next;
            count++;
        }
        ListNode node2 = node;
        ListNode prev = node_prev;
        ListNode next = node.next;
        while(count <= n){
            next = node2.next;
            node2.next = prev;
            prev = node2;
            node2 = next;
            count++;
        }
        if(node_prev == null){head = prev;}
        else{node_prev.next = prev;}
        node.next = node2;
        return head;
    }
}