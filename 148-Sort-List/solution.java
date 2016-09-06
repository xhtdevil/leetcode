/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null)return null;
        ListNode node = head;
        int length = 0;
        while(node != null){
            length++;
            node = node.next;
        }
        return helper(length, head);
    }
    
    private ListNode helper(int length, ListNode head){
        if(length <= 1 || head == null)return head;
        ListNode node = head.next;
        ListNode pre = head, mid = head;
        int ahead = 0;
        int count = length;
        while(count > 1){
            if(node.val < mid.val){
                pre.next = node.next;
                node.next = head;
                head = node;
                node = pre.next;
                ahead++;
            }
            else{
                pre = node;
                node = node.next;
            }
            count--;
        }
        if(ahead > 0){
            ListNode head1 = helper(ahead, head);
            node = head1;
            count = ahead;
            while(count > 1){
                node = node.next;
                count--;
            }
            node.next = mid;
            mid.next = helper(length - ahead - 1, mid.next);
            return head1;
        }
        else{
            mid.next = helper(length - ahead - 1, mid.next);
            return mid;
        }
    }
}