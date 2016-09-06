/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // quicksort: time exceed
    // public ListNode sortList(ListNode head) {
    //     if(head == null)return null;
    //     ListNode node = head;
    //     int length = 0;
    //     while(node != null){
    //         length++;
    //         node = node.next;
    //     }
    //     return helper(length, head);
    // }
    
    // private ListNode helper(int length, ListNode head){
    //     if(length <= 1 || head == null)return head;
    //     ListNode node = head.next;
    //     ListNode pre = head, mid = head;
    //     int ahead = 0;
    //     int count = length;
    //     while(count > 1){
    //         if(node.val < mid.val){
    //             pre.next = node.next;
    //             node.next = head;
    //             head = node;
    //             node = pre.next;
    //             ahead++;
    //         }
    //         else{
    //             pre = node;
    //             node = node.next;
    //         }
    //         count--;
    //     }
    //     if(ahead > 0){
    //         ListNode head1 = helper(ahead, head);
    //         node = head1;
    //         count = ahead;
    //         while(count > 1){
    //             node = node.next;
    //             count--;
    //         }
    //         node.next = mid;
    //         mid.next = helper(length - ahead - 1, mid.next);
    //         return head1;
    //     }
    //     else{
    //         mid.next = helper(length - ahead - 1, mid.next);
    //         return mid;
    //     }
    // }
    
    //Merge sort, bottom to up
    // public ListNode sortList(ListNode head) {
    //     if(head == null)return head;
    //     ListNode node = head, merge1 = null, merge2 = null, last = null, it = null;
    //     int length1 = 0, length2 = 0, iter = 0, length = 0, i = 0;
    //     while(node != null){
    //         length++;
    //         node = node.next;
    //     }
    //     ListNode vh = new ListNode(0);
    //     vh.next = head;
    //     for(int l = 1; l < length; l *= 2){
    //         iter = 0;
    //         last = vh;
    //         it = vh.next;
    //         while(iter < length){
    //             length1 = Math.min(length - iter, l);
    //             length2 = Math.min(length - iter - length1, l);
    //             merge1 = it;
    //             if(length2 != 0){
    //                 while(i < length1 - 1){
    //                     it = it.next;
    //                     i++;
    //                 }
    //                 merge2 = it.next;
    //                 it.next = null;
    //                 it = merge2;
    //                 i = 0;
    //                 while(i < length2 - 1){
    //                     it = it.next;
    //                     i++;
    //                 }
    //                 ListNode temp = it.next;
    //                 it.next = null;
    //                 it = temp;
    //                 i = 0;
    //             }
    //                 while(merge1 != null || merge2 != null){
    //                     if(merge2 == null || (merge1 != null && merge1.val < merge2.val)){
    //                         last.next = merge1;
    //                         merge1 = merge1.next;
    //                         last = last.next;
    //                     }else {
    //                         last.next = merge2;
    //                         merge2 = merge2.next;
    //                         last = last.next;
    //                     }
    //                 }
    //                 last.next = it;
    //                 iter += length1 + length2;
                
    //         }
    //     }
    //     return vh.next;
    // }
    
    //recursion
     public ListNode sortList(ListNode head) {
    if (head == null || head.next == null)
      return head;
        
    // step 1. cut the list to two halves
    ListNode prev = null, slow = head, fast = head;
    
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    
    prev.next = null;
    
    // step 2. sort each half
    ListNode l1 = sortList(head);
    ListNode l2 = sortList(slow);
    
    // step 3. merge l1 and l2
    return merge(l1, l2);
  }
  
  ListNode merge(ListNode l1, ListNode l2) {
    ListNode l = new ListNode(0), p = l;
    
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    
    if (l1 != null)
      p.next = l1;
    
    if (l2 != null)
      p.next = l2;
    
    return l.next;
  }

}