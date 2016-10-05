/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {val = x;}
 }
 
 class TreeMark {
     int loc;
     TreeNode node;
     TreeMark(int x, TreeNode treeNode) {
         loc = x;
         treeNode = node;
     }
 }
public class Solution {
    // public boolean isSymmetric(TreeNode root) {
    //     if(root == null)return true;
    //     List<TreeMark> list = new ArrayList<TreeMark>();
    //     //Map<Integer, TreeNode> map0 = new Map<Integer, TreeNode>();
    //     //map0.
    //     list.add(new TreeMark(0, root));
    //     int nodeNum = 1;
    //     while(list.size() != 0) {
    //         List<TreeMark> temp = new ArrayList<TreeMark>();
    //         int j = 0;
    //         for(int i = 0; i < list.size(); i++) {
    //             if((list.get(i).loc + list.get(list.size() - i - 1).loc != nodeNum - 1) 
    //             || list.get(i).node.val != list.get(list.size() - i - 1).node.val)return false;
                
    //             TreeMark mark = list.get(i);
    //             if(mark.node.left != null)temp.add(new TreeMark(j, mark.node.left));
    //             j++;
    //             if(mark.node.right != null)temp.add(new TreeMark(j, mark.node.right));
    //             j++;
    //         }
    //         nodeNum *= 2;
    //         list = temp;
    //     }
    //     return true;
    // }
    //recursive
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        return help(root.left, root.right);
    }
    
    private boolean help(TreeNode left, TreeNode right) {
        if(left == null || right == null) {
            return left == right;
            
        }
        else if(left.val != right.val)return false;
        return help(left.left, right.right) && help(left.right, right.left);
    }
}