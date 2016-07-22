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
    private int isRoot = 1;
    public int minDepth(TreeNode root) {
        // int minD = 0;
        // if(root == null){return 0;}
        // if(root.left == null && root.right == null){return 1;}
        // if(root.left == null && root.right != null){
        //     root = root.right;
        //     minD++;
        // }
        // while(root != null){
            
        // }
        if(root == null){return 0;}
        else if(root.right == null && root.left == null){
            return 1;
        }
         else if(root.left == null && root.right != null){
             return minDepth(root.right) + 1;
         }
         else if(root.right == null && root.left != null){
             return minDepth(root.left) + 1;
         }
        else{
            isRoot = 0;
            return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
        }
    }
}