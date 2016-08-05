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
    public int rob(TreeNode root) {
        if(root == null){return 0;}
        int ans[] = robSub(root);
        return Math.max(ans[0], ans[1]);
    }
    
    private int[] robSub(TreeNode root){
        if(root == null)return new int[2];
        int right[] = robSub(root.right);
        int left[]  = robSub(root.left);
        int res[] = new int[2];
        res[0] = Math.max(right[0], right[1]) + Math.max(left[0], left[1]);
        res[1] = root.val + right[0] + left[0];
        return res;
    }
}