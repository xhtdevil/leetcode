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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0)return new ArrayList<TreeNode>();
        return helper(1, n); 
    }
    
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(start > end){
            list.add(null);
            return list;
        }
        if(start == end){
            TreeNode node = new TreeNode(start);
            list.add(node);
            return list;
        }
        else{   
            List<TreeNode> left = new ArrayList<TreeNode>();
            List<TreeNode> right = new ArrayList<TreeNode>();
            for(int i = start; i <= end; i++){
                    // List<TreeNode> left = new ArrayList<TreeNode>();
                    // List<TreeNode> right = new ArrayList<TreeNode>();
                left = helper(start, i - 1);
                right = helper(i + 1, end);
                for(int m = 0; m < left.size(); m++){
                    for(int n = 0; n < right.size(); n++){
                        TreeNode node = new TreeNode(i);
                        node.left = left.get(m);
                        node.right = right.get(n);
                        list.add(node);
                    }
                }
            }
            return list;
        }
    }
}