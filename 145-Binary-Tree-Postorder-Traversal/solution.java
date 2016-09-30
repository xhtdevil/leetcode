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
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     List<Integer> list = new ArrayList<Integer>();
    //     if(root == null)return list;
    //     TreeNode node = root;
    //     while(true){
    //         while(node != null) {
    //             stack.push(node);
    //             node = node.left;
    //         }
    //         node = stack.peek();
    //         while(node.right == null) {
    //             list.add(node.val);
    //             stack.pop();
    //             if(!stack.isEmpty()) {
    //                 node = stack.peek();
    //             }
    //             else return list;
    //         }
    //             node = node.right;
    //     }
    //     // while(!stack.isEmpty()) {
    //     //     node = stack.pop();
    //     //     if(node.right != null)
    //     //     list.add(node.val);
    //     // }
    // }
    
     public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode cur = root;
        
        while (cur != null || !s.empty()) {
            while (!isLeaf(cur)) {
                s.push(cur);
                cur = cur.left;
            }
            
            if (cur != null) ans.add(cur.val);
            
            while (!s.empty() && cur == s.peek().right) {           //pop the root if its children has been visited
                cur = s.pop();
                ans.add(cur.val);
            }
            
            if (s.empty()) cur = null; else cur = s.peek().right;
        }
        
        return ans;
    }
    
    private boolean isLeaf(TreeNode r) {
        if (r == null) return true;
        return r.left == null && r.right == null;
    }
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     if(root == null)return new ArrayList<Integer>();
    //     List<Integer> list = new ArrayList<Integer>();
    //     List<Integer> Rlist = postorderTraversal(root.right);
    //     List<Integer> Llist = postorderTraversal(root.left);
    //     list.addAll(Llist);
    //     list.addAll(Rlist);
    //     list.add(root.val);
    //     return list;
    // }
}