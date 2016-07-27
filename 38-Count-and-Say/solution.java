public class Solution {
    public String countAndSay(int n) {
        String cs = "1";
        for(int i = 0; i < n - 1; i++){                                                 
            String cs2 = "";
            Stack<Character> stack = new Stack<Character>();
            for(int j = 0; j < cs.length(); j++){
                if(stack.isEmpty() || stack.peek() == cs.charAt(j)){stack.push(cs.charAt(j));}
                else{
                    int count = 0;
                    char t = stack.peek();
                    while(!stack.isEmpty()){
                        count++;
                        stack.pop();
                    }
                    cs2 = cs2 + count + t;
                    stack.push(cs.charAt(j));
                }
            }
            if(!stack.isEmpty()){
                int count = 0;
                char t = stack.peek();
                while(!stack.isEmpty()){
                count++;
                stack.pop();
                }
                cs2 = cs2 + count + t;
            }
            cs = cs2;
        }
        return cs;
    }
}