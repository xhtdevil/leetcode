public class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int[] memo = new int[n+1];
        memo[n]  = 1;
        memo[n-1] = s.charAt(n-1) != '0' ? 1 : 0;
        
        for (int i = n - 2; i >= 0; i--)
            if (s.charAt(i) == '0') continue;
            else memo[i] = (Integer.parseInt(s.substring(i,i+2))<=26) ? memo[i+1]+memo[i+2] : memo[i+1];
        
        return memo[0];
    }
//   Map<String, Integer> map = new HashMap<String, Integer>();
    
//     public int numDecodings(String s) {
//         if(s.length() == 0)return 0;
//         return help(s);
//     }
    
//     private int help(String s) {
//         if(map.containsKey(s))return map.get(s);
//         if(s.length() == 0) {
//             return 1;
//         }
//         int ans;
//         String s1 = s.substring(0, 1);
//         int a1 = Integer.valueOf(s1);
//         if(a1 == 0) {
//             ans = 0;
//             map.put(s, 0);
//             return ans;
//         }
        
//         if(s.length() >= 2){
//             int a2 = Integer.valueOf(s.substring(0, 2));
        
//             if(a2 > 26) {
//                 ans = help(s.substring(1));
//             }
//             else {
//                 ans = help(s.substring(1)) + help(s.substring(2));
//             }
            
//         }
//         else {
//             ans = help(s.substring(1));
//         }
        
//         map.put(s, ans);
//         return ans;
//     }
}