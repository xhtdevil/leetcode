/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return head;
        // int duplicate = -1;
        // ListNode node = head.next;
        // ListNode pre = head;
        // ListNode pre_pre = null;
        // while(node != null){
        //     if(node.val == pre.val){
        //         if()
        //         pre_pre.next = node.next;
        //         duplicate = node.val;
        //         pre = pre_pre;
        //         node = node.next;
        //     }
        //     if(node.val == duplicate){
        //         pre.next = node.next;
        //         node = node.next;
        //     }
        //     else{
        //         prev_prev = prev;
        //         prev = node;
        //         node = node.next;
        //         duplicate = -1;
        //     }
        // }
        int duplicate = 0;
        ListNode node = head;
        ListNode prev = new ListNode(0);
        prev.next = head;
        while(node != null){
            if(node.next != null && node.next.val == node.val){
                node.next = node.next.next;
                duplicate = 1;
            }
            
            else if(duplicate == 1){
                duplicate = 0;
                if(prev.next == head){head = node.next;}
                prev.next = node.next;
                node = node.next;
            }
            
            else{
                prev = node;
                node = node.next;
            }
        }
        return head;
    }
}