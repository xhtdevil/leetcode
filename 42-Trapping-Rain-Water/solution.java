public class Solution {
    // public int trap(int[] height) {
    //     if(height.length <= 2)return 0;
    //     int max = 0, rain = 0;
    //     for( int i = 0; i < height.length; i++) {
    //         if(i != 0 && i != height.length - 1 && height[i] > height[i - 1] && height[i] > height[i + 1] || i == 0 && height[i] > height[i + 1] || i == height.length - 1 && height[i] > height[i - 1]) {
    //             if(i != 0) {
    //                 rain += help(height, max, i);
    //             }
    //             max = i;
    //         }
    //     }
    //     return rain;
    // }
    
    // private int help(int[] height, int left, int right) {
    //     int level = Math.min(height[left], height[right]);
    //     int sum = 0;
    //     for(int i = left + 1; i < right; i++) {
    //         if(level - height[i] > 0) {
    //             sum += level - height[i];
    //         }
    //     }
    //     return sum;
    // }
    
    public int trap(int[] height) {
        int l = 0, r = height.length - 1, rain = 0;
        while(l < r) {
            int left = height[l];
            int right = height[r];
            if(left < right) {
                while(left > height[++l]) {
                    rain += left - height[l];
                }
            }
            else {
                while(right > height[--r]) {
                    rain += right - height[r];
                }
            }
        }
        return rain;
    }
}