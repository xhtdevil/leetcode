/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        // NestedInteger res = new NestedInteger();
        // if(!s.contains("[")){
        //     res.setInteger(stringToInt(s));
        //     return res;
        // }
        // int i = indexOf('['), j = lastIndextOf(']');
        // String[] sArray = s.substring(i + 1, j).split(",");
        // for(int i = 0; i < sArray.length; i++){
        //     if(sArray[i].contains("["))res.add(deserialize(sArray[i]));
        //     else{
        //         res.add(stringToInt(sArray[i]));
        //     }
        // }
        // return res;
        
        Stack<NestedInteger> stack = new Stack<NestedInteger>();
        NestedInteger cur = null;
        if(s.length() == 0)return null;
        if(s.charAt(0) != '[')return new NestedInteger(Integer.valueOf(s));
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '['){
                if(cur != null)stack.push(cur);
                cur = new NestedInteger();
                start = i + 1;
            }
            else if(c == ']'){
                String sub = s.substring(start, i);
                if(sub.length() != 0){
                    NestedInteger ni = new NestedInteger(Integer.valueOf(sub));
                    cur.add(ni);
                }
                if(!stack.isEmpty()){
                    NestedInteger pop = stack.pop();
                    pop.add(cur);
                    cur = pop;
                }
                start = i + 1;
            }
            else if(c == ','){
                if(s.charAt(i - 1) != ']'){
                    String sub = s.substring(start,i);
                    cur.add(new NestedInteger(Integer.valueOf(sub)));
                }
                start = i + 1;
            }
            
        }
        return cur;
    }
}