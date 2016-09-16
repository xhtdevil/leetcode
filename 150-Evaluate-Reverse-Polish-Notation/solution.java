public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<String>();
        if(tokens.length == 0)return 0;
        for(String s : tokens){
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                String s1 = stack.pop();
                String s2 = stack.pop();
                String ans = "";
                if(s.equals("+")){
                    ans += Integer.parseInt(s1) + Integer.parseInt(s2);
                }
                if(s.equals("-")){
                    ans += Integer.parseInt(s2) - Integer.parseInt(s1);
                }
                if(s.equals("*")){
                    ans += Integer.parseInt(s2) * Integer.parseInt(s1);
                }
                if(s.equals("/")){
                    ans += Integer.parseInt(s2) / Integer.parseInt(s1);
                }
                stack.push(ans);
            }else{
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}