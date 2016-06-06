/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode head = null, node3 = head;
        if(l1 == null && l2 == null){                           //find the head of merged list
            return null;
        }
        else if(l1 != null && l2 == null){return l1;}
        else if(l1 == null && l2 != null){return l2;}
        else if(node1.val <  node2.val){
            node3 = node1;
            head = node1;
            node1 = node1.next;
        }else{
            node3 = node2;
            head = node2;
            node2 = node2.next;
        }
        while(node1 != null && node2 != null){                  //link and merge two lists according to val
            if(node1.val <  node2.val){
                node3.next = node1;
                node1 = node1.next;
                node3 = node3.next;
            }
            else{
                node3.next = node2;
                node2 = node2.next;
                node3 = node3.next;
            }
        }
        if(node1 == null){
            node3.next = node2;
        }
        else{
            node3.next = node1;
        }
        return head;
    }
}