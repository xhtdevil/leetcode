public class Solution {
    public int mySqrt(int x) {
        if(x == 0)return 0;
        if(x == 1)return 1;
        int l = 0, r = x;
        int mid = l + (r - l) / 2;
        while(l <= r){
            mid = l + (r - l) / 2;
            if((mid != 0 && mid > x / mid)){
                r = mid - 1;
            }else{
                if((mid + 1) > x / (mid + 1))return mid;
                l = mid + 1;
            }
        }
        return 0;
    }
}