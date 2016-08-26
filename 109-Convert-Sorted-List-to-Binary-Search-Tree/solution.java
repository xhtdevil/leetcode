/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)return null;
        TreeNode root = new TreeNode(0);
        half(head, root);
        return root;
    }
    
    private void half(ListNode head, TreeNode root){
        if(head == null){
            return;
        }
        ListNode node1 = head, node2 = head, pre = node1;
        while(node2 != null && node2.next != null){
            node2 = node2.next.next;
            pre = node1;
            node1 = node1.next;
        }
        root.val = node1.val;                   //mid point of the list
        if(node1.next != null){
            TreeNode right = new TreeNode(0);
            half(node1.next, right);
            root.right = right;
        }
        else{
            root.right = null;
        }
        if(node1 != head){
            pre.next = null;
            TreeNode left = new TreeNode(0);
            half(head, left);
            root.left = left;
        }
        else{
            root.left = null;
        }
    }
}