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
    //Time limit exceed
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root == null)return null;
    //     if(isDescent(root.right, p) && isDescent(root.right, q))return lowestCommonAncestor(root.right, p, q);
    //     if(isDescent(root.left, p) && isDescent(root.left, q))return lowestCommonAncestor(root.left, p, q);
    //     else return root;
    // }
    
    // private boolean isDescent(TreeNode root, TreeNode child){
    //     if(root == null)return false;
    //     if(root == child)return true;
    //     return isDescent(root.right, child) || isDescent(root.left, child);
    // }
    
    private boolean isDescent(TreeNode root, TreeNode child, List<TreeNode> path){
        if(root == null)return false;
        if(root == child){
            path.add(root);
            return true;
        }
        if(isDescent(root.left, child, path)){
            path.add(root.left);
            return true;
        }
        else if(isDescent(root.right, child, path)){
            path.add(root.right);
            return true;
        }
        return false;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p == q)return p;
        List<TreeNode> pathp = new ArrayList<TreeNode>();
        List<TreeNode> pathq = new ArrayList<TreeNode>();
        if(isDescent(root, p, pathp) && isDescent(root, q, pathq)){
            for(int i = pathp.size() - 1, j = pathq.size() - 1; i > 0 || j > 0; i--, j--){
                if(pathp.get(i) == pathq.get(j) && pathp.get(i - 1) != pathq.get(j - 1))return pathp.get(i);
            }
        }
    }
}