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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k == 0)return 0;
        List<Integer> list = new ArrayList<Integer>();
        Inorder(root, list);
        return list.get(k - 1);
    }
    private void Inorder(TreeNode root, List<Integer> list){
        if(root == null)return ;
        Inorder(root.left, list);
        list.add(root.val);
        Inorder(root.right, list);
    }
    
}