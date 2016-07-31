public class Solution {
    public int[] countBits(int num) {
        int nums[] = new int[num + 1];
        for(int i = 1; i <= num; i++){
            nums[i] = nums[i / 2] + i % 2;
        }
        return nums;
        // int maxAdd = 1;
        // int countAdd = 1;
        // int ans = 1;
        // int nums[] = new int[num + 1];
        // for(int i = 0; i <= num; i++){
        //     if(i == 0){nums[i] = 0;continue;}
        //     if(countAdd < maxAdd){
        //         nums[i] = ans;
        //         ans++;
        //         countAdd++;
        //     }else{
        //         nums[i] = ans;
        //         ans = 1;
        //         countAdd = 1;
        //         maxAdd = maxAdd * 2;
        //     //    nums[i] = ans;
        //   //     ans++;
        //     //    countAdd++;
        //     }
        // }
        // return nums;
    }
}