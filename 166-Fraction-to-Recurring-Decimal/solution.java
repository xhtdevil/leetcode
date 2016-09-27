public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        String ans = "";
        if(numerator == 0)return "0";
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        if((numerator > 0) ^ (denominator > 0)) {ans += '-';}       //multiply will overflow, detect negtive
        ans = ans + num / den;
        num = num % den;
        if(num == 0)return ans;
        ans += '.';

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        
        map.put(num, ans.length());
  
        while(num != 0) {
            num = num * 10;
            ans = ans + num / den;
            num = num % den;
            if(!map.containsKey(num)) {
                
                map.put(num, ans.length());
            }
            else {
                int index = map.get(num);
                return ans.substring(0, index) + '(' + ans.substring(index) + ')';
            }
            
            
        }
        
        return ans;
    }
}