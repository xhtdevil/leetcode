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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> Tree = new ArrayList<List<Integer>>();
        int level = 0;
        levelBuild(Tree, level, root);
        return Tree;
        // while(TreeNode != null){
            
        // }
        // Tree.add(new ArrayList<Integer>);
        // Tree.get(i).add(TreeNode.val);
    }
    private void levelBuild(List<List<Integer>> Tree, int level, TreeNode node){
        if(node == null){return;}
        if(level == Tree.size()){Tree.add(new ArrayList<Integer>());}
        Tree.get(level).add(node.val);
        level++;
        levelBuild(Tree, level, node.left);
        levelBuild(Tree, level, node.right);
        
    }
}