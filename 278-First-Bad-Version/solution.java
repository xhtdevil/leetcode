/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int test = n / 2;
        int start = 1, end = n;
        while(start < end){
            if(isBadVersion(test)){
                end = test;
            }else{
                start = test + 1;
            }
            test = (start + end) / 2;
        }    
        return start;
    }
}