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
    public void flatten(TreeNode root) {
        if(root == null)return;
        if(root.right != null)flatten(root.right);
        if(root.left != null){
            flatten(root.left);
            TreeNode node = root.left;
            while(node.right != null){
                node = node.right;
            }
            TreeNode right = root.right;
            TreeNode left = root.left;
            root.right = left;
            node.right = right;
            root.left = null;
        }
    }
}