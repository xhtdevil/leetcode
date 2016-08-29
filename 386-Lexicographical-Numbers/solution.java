public class Solution {
    public List<Integer> lexicalOrder(int n) {
        // int temp = n;
        // int l = 0;
        // while(temp != 0){
        //     temp = temp / 10;
        //     l++;
        // }
        // List<Integer> ans = new List<Integer>();
        // for(int i = 1; i < 10; i++){
        //     ans.add(i);
            
        // }
        List<Integer> ans = new ArrayList<Integer>();
        helper(n, ans, 0);
        return ans;
    }
    
    private void helper(int n, List<Integer> ans, int j){
        for(int i = 0; i < 10; i++){
            if(n >= 10 * j + i && 10 * j + i != 0){
                ans.add(10 * j + i);
                helper(n, ans, 10 * j + i);
            }
            else if(n < 10 * j + i)return;
        }
    }
}