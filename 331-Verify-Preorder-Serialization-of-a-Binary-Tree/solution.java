public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack<String>();
        String[] binaryTree = preorder.split(",");
        for(int i = binaryTree.length - 1; i >= 0; i--){
            stack.push(binaryTree[i]);
        }
        if(stack.isEmpty())return true;
        if(helper(stack) && stack.isEmpty()){
            return true;
        }
        else return false;
        // while(!stack.isEmpty()){
        //     String top = stack.pop();
            
        // }
    }
    
    private boolean helper(Stack<String> stack){
        if(stack.isEmpty())return false;
         String top = stack.pop();
         if(!top.equals("#")){
             return helper(stack) && helper(stack);
         }
         else{
             return true;
         }
    }
}