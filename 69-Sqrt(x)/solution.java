public class Solution {
    public int mySqrt(int x) {
        int l = 0, r = x;
        int mid = l + (x - l) / 2;
        while(l <= r){
            mid = l + (x - l) / 2;
            if(mid < x / mid){
                l = mid + 1;
            }else{
                if((mid + 1) < x / (mid + 1))return mid;
                r = mid - 1;
            }
        }
        return 0;
    }
}