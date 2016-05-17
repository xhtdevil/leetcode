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
    public int maxDepth(TreeNode root) {
        int maxDepth;
        TreeNode node = root;
        if(node != null){
            int rightMaxDepth = maxDepth(node.right);
            int leftMaxDepth = maxDepth(node.left);
            if(rightMaxDepth > leftMaxDepth){
                maxDepth = rightMaxDepth + 1;
            }else{
                maxDepth = leftMaxDepth + 1;
            }
        }else{
            maxDepth = 0;
        }
        return maxDepth;
    }
}