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
    private List<String> StringList = new ArrayList<String>(); 
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null){return ;}
        String Path = root.val + "";
        binaryTreePathsRecord(root.right, Path);
        binaryTreePathsRecord(root.left, Path);
        return StringList;
    }
    private void binaryTreePathsRecord(TreeNode root, String Path){
        if(root == null){return ;}
        Path = Path + "->" + root.val;
        if(root.left == null && root.right == null){StringList.add(Path);}
        else{
            binaryTreePathsRecord(root.left, Path);
            binaryTreePathsRecord(root.right, Path);
        }
    }
}