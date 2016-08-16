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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode node = root;
        helper(root, list, 0);
        return list;
        // if(node == null)return null;
        // int depth = 0;
        // while(node.right != null || node.left != null){
        //     list.add(node.val);
        //     if(node.right != null && depth == list.size()){
        //         node = node.right;
        //         depth++;
        //     }
        //     if(node.left != null){
        //         node = node.left;
        //         depth++;
        //     }
        // }
    }
    
    private void helper(TreeNode root, List<Integer> list, int depth){
        if(root == null)return;
        if(depth == list.size()){list.add(root.val);}
        helper(root.right, list, depth + 1);
        helper(root.left, list, depth + 1);
    }
}