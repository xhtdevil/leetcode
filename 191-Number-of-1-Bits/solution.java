public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
	        long res;
	        int ans = 0;
	        long m = n&0x0FFFFFFFFL;//Must add 'L' as a long type, convert from int(8 bytes) to long(16 bytes)
	        while(m != 0){
	                res = m % 2;
	                m = m / 2;
	               if(res != 0){ans++;}
	        }
	        return ans;
    }
}