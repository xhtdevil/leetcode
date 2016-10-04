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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null)return ans;
        List<TreeNode> listNode = new ArrayList<TreeNode>();
        List<Integer> listValue = new ArrayList<Integer>();
        listNode.add(root);
        listValue.add(root.val);
        help(listValue, listNode, ans);
        return ans;
    }
    
    private void help(List<Integer> listValue, List<TreeNode> listNode, List<List<Integer>> ans) {
        while(listNode.size() != 0) {
            ans.add(0, listValue);
            List<TreeNode> tempNode = new ArrayList<TreeNode>();
            List<Integer> tempValue = new ArrayList<Integer>();
            for(TreeNode node : listNode) {
                if(node.left != null) {
                    tempNode.add(node.left);
                    tempValue.add(node.left.val);
                }
                if(node.right != null) {
                    tempNode.add(node.right);
                    tempValue.add(node.right.val);
                }
            }
            listNode = tempNode;
            listValue = tempValue;
        }
    }
}