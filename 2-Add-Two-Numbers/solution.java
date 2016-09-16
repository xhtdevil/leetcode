/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        //l3.next = new ListNode(0);
        ListNode head = l3;
        int carry = 0;
        while(l1 != null || l2 != null || carry == 1){
            if(l1 != null && l2 != null){
               
                l3.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
                l1 = l1.next;
                l2 = l2.next;
                if(l1 == null && l2 == null && carry == 0)break;
                l3.next = new ListNode(0);
                l3 = l3.next;
            }
            
            else if(l1 != null){
                
                l3.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                l1 = l1.next;
                if(l1 == null && carry == 0)break;
                l3.next = new ListNode(0);
                l3 = l3.next;
            }
            
            else if(l2 != null){
                
                l3.val = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                l2 = l2.next;
                if(l2 == null && carry == 0)break;
                l3.next = new ListNode(0);
                l3 = l3.next;
            }
            
            else{
                
                l3.val = carry % 10;
                carry =  carry / 10;
                if(carry == 0)break;
                l3.next = new ListNode(0);
                l3 = l3.next;
            }
            
        }
        
        return head;
    }
}