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
        ListNode nodeI = new ListNode();
        while(nodeA != null){
            if(nodeA == nodeB){
                nodeI = nodeA;
            }else{
                nodeA = nodeA.next;
                nodeB = nodeB.next;
            }
        }
        return nodeI;
    }
}