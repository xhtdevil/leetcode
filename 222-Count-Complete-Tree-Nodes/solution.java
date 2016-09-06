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
    
    private int getDepth(TreeNode root) {
        if(root == null)return 0;
        TreeNode node = root;
        int depth = 0;
        while(node != null){
            depth++;
            node = node.left;
        }
        return depth;
    }
    public int countNodes(TreeNode root) {
        if(root == null)return 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if(leftDepth == rightDepth){
           //return (int) Math.pow(2, (double)leftDepth) + countNodes(root.right);
           return  (1 << leftDepth) + countNodes(root.right);           
           //note 1 << leftDepth + countNodes means 1<<(left + countNodes)
        }
        else{
            //return (int) Math.pow(2, (double)rightDepth) + countNodes(root.left);
            return  (1 << rightDepth) + countNodes(root.left);
        }
    }
}