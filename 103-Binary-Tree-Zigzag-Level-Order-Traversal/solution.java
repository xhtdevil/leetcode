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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        helper(root, 0, ans);
        return ans;
    }
    
    private void helper(TreeNode root, int level, List<List<Integer>> ans){
        if(root == null)return;
        if(level >= ans.size()){ans.add(new ArrayList<Integer>());}
        if(level % 2 == 0)ans.get(level).add(root.val);
        else{ans.get(level).add(0,root.val);}
        helper(root.left, level + 1, ans);
        helper(root.right, level + 1, ans);
    }
}