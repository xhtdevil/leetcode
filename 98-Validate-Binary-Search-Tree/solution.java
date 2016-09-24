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
    public boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        TreeNode LS, RS;
        //if(root.left != null){
            LS = root.left;
            if(LS != null){
            while(LS.right != null){
                LS = LS.right;
            }
            }
        //}
       // if(root.right != null){
            RS = root.right;
            if(RS != null){
                while(RS.right != null){
                    RS = RS.left;
                }
            }
        //}
        if((root.right == null || RS.val > root.val) && (root.left == null || LS.val < root.val) && isValidBST(root.right) && isValidBST(root.left)){
            return true;
        }
        else return false;
    }
}