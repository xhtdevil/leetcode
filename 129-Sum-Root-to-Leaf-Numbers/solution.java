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
    public int sumNumbers(TreeNode root) {
       
        return helper(root, 0);
    }
    
    // private int height(TreeNode root){
    //     if(root == null)return 0;
    //     return Math.max(height(root.right), height(root.left)) + 1;
    // }
    
    private int helper(TreeNode root, int sum){ //record the sum before the root
        if(root == null)return 0;
        if(root.left == null && root.right == null)return sum * 10 + root.val;
        return helper(root.left, 10 * sum + root.val) + helper(root.right, 10 * sum + root.val); 
    }
    
    
}