public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) =='{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty()){return false;}
                char c = stack.pop();
                if(c == '(' && s.charAt(i) == ')' || c == '[' && s.charAt(i) == ']' || c == '{' && s.charAt(i) =='}'){
                    continue;
                }
                else return false;
            }
        }
        if(stack.isEmpty())return true;
        else return false;
        // int sb = 0, mb = 0, bb = 0;
        // int length = s.length();
        // if(length % 2 == 1)return false;
        // for(int i = 0; i < length / 2; i++){
        //     if(s.charAt(i) == '(' && s.charAt(length - i - 1) == ')' || s.charAt(i) == '[' && s.charAt(length - i - 1) == ']' || s.charAt(i) == '{' && s.charAt(length - i - 1) == '}'){continue;}else return false;
            // if(s.charAt(i) == '('){
            //     sb++;
            // }else if(s.charAt(i) == '['){
            //     mb++;
            // }else if(s.charAt(i) == '{'){
            //     bb++;
            // }else if(s.charAt(i) == ')'){
            //     sb--;
            //     if(sb < 0)return false;
            // }else if(s.charAt(i) == ']'){
            //     mb--;
            //     if(mb < 0)return false;
            // }else if(s.charAt(i) == '}'){
            //     bb--;
            //     if(bb < 0)return false;
            // }//char can use "==" instead of equals()
        // }
        // if(sb == 0 && mb == 0 && bb == 0){return true;}
        // else{return false;}
    }
}