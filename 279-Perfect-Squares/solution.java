public class Solution {
    
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    
    public int numSquares(int n) {
        if(n == 0)return 0;
        if(map.containsKey(n)){return map.get(n);}
        double root = Math.sqrt((double) n);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= root; i++){
            int x = numSquares(n - i * i) + 1;
            if(x < min)min = x;
        }
        map.put(n, min);
        return min;
    }
}