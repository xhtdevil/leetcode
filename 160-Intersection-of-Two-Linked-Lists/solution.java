/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while(length(nodeA) > length(nodeB)){
            nodeA = nodeA.next;
        }
        while(length(nodeA) < length(nodeB)){
            nodeB = nodeB.next;
        }
        while(nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }
    private int length(ListNode head){
        int length = 0;
        while(head != null){
            head = head.next;
            length++;
        }
        return length;
    }
}