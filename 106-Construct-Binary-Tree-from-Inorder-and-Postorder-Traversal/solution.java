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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int ins, int ine, int pos, int poe){
        if(ins <= ine && pos <= poe){
            for(int i = ins; i < ine + 1; i ++){
                if(inorder[i] == postorder[poe]){
                    TreeNode root = new TreeNode(inorder[i]);
                    root.left = helper(inorder, postorder, ins, i - 1, pos, i - ins - 1 + pos);
                    root.right = helper(inorder, postorder, i + 1, ine, i - ins + pos, poe - 1);
                    return root;
                }
            }
            return new TreeNode(0);
        }
        else return null;
    }
}