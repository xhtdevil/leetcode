public class Solution {
    
    List<String> par = new ArrayList<String>();
    
    public List<String> generateParenthesis(int n) {
        int endN = 2 * n - 1;
       // List<String> par = new ArrayList<String>();
        int[] c = new int[2 * n];
        int parSum = 0; 
        helper(c, parSum, 0, endN);
        return par;
    }
    
    private void helper(int[] c, int parSum, int currentN, int endN){
        for(int i = -1; i < 2; i += 2){
            parSum += i;
            c[currentN] = i;
            if(parSum >= 0){
                if(currentN == endN && parSum == 0){
                    String s = "";
                    for(int j = 0; j < endN + 1; j++){
                        if(c[j] == 1){
                            s += "(";
                        }else if(c[j] == -1){
                            s += ")";
                        }
                    }
                    par.add(s);
                }
                else if(currentN < endN){
                    helper(c, parSum, currentN + 1, endN);
                }
            }
            parSum -= i;
        }
    }
}