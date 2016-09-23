public class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("\\/");
        Stack<String> stack = new Stack<String>();
        int count = 0;
        List<String> level = new ArrayList<String>();
        for(int i = 0; i < str.length; i++){
            if(str[i].length() == 0 || str[i].equals("."))continue;
            else if(str[i].equals("..")){
                if(!stack.isEmpty())stack.pop();
            }
            else {
                stack.push(str[i]);
            }
        }
        String ans = "";
        if(stack.isEmpty())return "/";
        while(!stack.isEmpty()){
            ans = '/' + stack.pop() + ans;
        }
        return ans;
    }
}