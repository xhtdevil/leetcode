/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)return head;
        ListNode node1 = new ListNode(0);
        node1.next = head;
        //ListNode ans = node1.next;
        ListNode node2 = head;
        ListNode preNode2 = head;
        while(node2 != null && node1 != null){
            if(node2.val < x && node1.next != node2){
                if(node1.next == head){
                    head = node2;                        //change the head if node2 is inserted to the head
                }
                preNode2.next = node2.next;
                node2.next = node1.next;
                node1.next = node2;
                node2 = preNode2;
            }
            preNode2 = node2;
            node2 = node2.next;
            if(node1.next.val < x){
                node1 = node1.next;
            }
           
        }
        return head;
    }
}