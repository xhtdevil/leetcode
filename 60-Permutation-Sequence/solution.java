public class Solution {
    public String getPermutation(int n, int k) {
        List<String> nums = new LinkedList<String>();
        String ans = "";
        int mul = 1;
        for(int i = 1; i <= n; i++){
            nums.add(i + "");
            mul *= i;
        }
        int rem = k - 1;
        for(int i = n; i >= 1; i--){
            mul /= i;
            ans += nums.get(rem / mul);
            nums.remove(rem / mul);
            rem = rem % mul;
        }
        return ans;
    }
}