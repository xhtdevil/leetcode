public class Solution {
    //brutal force 
    // public boolean isMatch(String s, String p) {
    //     int i = 0, j = 0;
    //     if(s.length() == 0 && p.length() == 0) return true;
    //     while(i < s.length() || j < p.length()) {
            
    //         if(i < s.length() && j == p.length()) return false;
    //         //if(i == s.length() && j < p.length())if(p.charAt()
    //         if(i < s.length() && s.charAt(i) == p.charAt(j)) {
    //             i++;
    //             j++;
    //         }
    //         else if(p.charAt(j) != '.' && p.charAt(j) != '*' ) {
    //             if(j != p.length() - 1 && p.charAt(j + 1) == '*') {
    //                 j += 2;
    //             }
    //             else return false;
    //         }
    //         else if(p.charAt(j) == '*') {
    //             if(j == 0)return false;
    //             //if(i == s.length()) return isMatch(s.substring(i), p.substring(j + 1));
    //             int m = i - 1;
    //             while(m < s.length() && s.charAt(m) == p.charAt(j - 1)) {
    //                 if(isMatch(s.substring(m), p.substring(j + 1))) return true;
    //                 m++;
    //             }
    //             if(isMatch(s.substring(m), p.substring(j + 1))) return true;
    //             else return false;
    //         }
    //         else {
    //             if(j == p.length() - 1 || p.charAt(j + 1) != '*') {
    //                 if(i >= s.length()) return false;
    //                 i++;
    //                 j++;
    //             } 
    //             else {
    //                 int m = i;
    //               // char c = s.charAt(m);
    //                 while(m < s.length()) {
    //                     if(isMatch(s.substring(m), p.substring(j + 2))) return true;
    //                     m++;
    //                 }
    //                 if(isMatch(s.substring(m), p.substring(j + 2))) return true;
    //                 else return false;
    //             }
    //         }
            
    //     }
    //     return true;
    // }
    
    //dp solution
    public boolean isMatch(String s, String p) {

    if (s == null || p == null) {
        return false;
    }
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for (int i = 0; i < p.length(); i++) {
        if (p.charAt(i) == '*' && dp[0][i-1]) {
            dp[0][i+1] = true;
        }
    }
    for (int i = 0 ; i < s.length(); i++) {
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '.') {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == s.charAt(i)) {
                dp[i+1][j+1] = dp[i][j];
            }
            if (p.charAt(j) == '*') {
                if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                    dp[i+1][j+1] = dp[i+1][j-1];
                } else {
                    dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                }
            }
        }
    }
    return dp[s.length()][p.length()];
}
}