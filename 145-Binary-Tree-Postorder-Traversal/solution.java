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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null)return new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> Rlist = postorderTraversal(root.right);
        List<Integer> Llist = postorderTraversal(root.left);
        list.addAll(Llist);
        list.addAll(Rlist);
        list.add(root.val);
        return list;
    }
}