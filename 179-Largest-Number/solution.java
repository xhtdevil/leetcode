public class Solution {
    public String largestNumber(int[] nums) {
        String[] str = arrayToString(nums);
        Comparator<String> comp = new Comparator<String>(){     //override compare
            @Override                                           // if str1 + str2 > str2 + str1 then str1 > str2;
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(str, comp);
        String ans = "";
        for(int i = 0; i < str.length; i++){
            ans +=  str[i];
        }
        if(ans.charAt(0) == '0')ans = "0";
        return ans;
    }
    
    private String[] arrayToString(int[] nums) {            //transfer from int to string to compare dictionally
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            str[i] = nums[i] + "";
        }
        return str;
    }
    
    // private void sortString(String[] str) {
    //     int max = 0;
    //     String[] com = new String[str.length];
    //     for(int i = 0; i < str.length; i++){
    //         com[i] = str[i];
    //     }
    //     for(int i = 0; i < str.length; i++){
    //         if( str[i].length() > max ){
    //             max = str[i].length();
    //         }
    //     }
        
    //      for(int i = 0; i < com.length; i++){
    //         while( com[i].length() < max ){
    //             com[i] = com[i] + com[i].charAt(0);
    //         }
    //     }
        
    //     quickSort(com, str, 0, str.length - 1);
        
    // }
    
    // private void quickSort(String[] com, String[] str, int left, int right){
    //     if(left >= right)return;
    //     int i = left + 1, j = right;
    //     while(i <= j) {
    //         if(com[i].compareTo(com[left]) < 0){            //compare dictionarily, return smaller than 0 if com[i] < com[left]
    //             swap(com, str, i, j);
    //             j--;
    //         }
    //         else{
    //             i++;
    //         }
    //     }
    //     //return;
    //     swap(com, str, i - 1, left); 
    //     quickSort(com, str, left, j - 1);
    //     quickSort(com, str, i, right);
    // }
    
    // private void swap(String[] com, String[] str, int i, int j){
    //     String temp1 = com[i];
    //     com[i] = com[j];
    //     com[j] = temp1;
    //     String temp2 = str[i];
    //     str[i] = str[j];
    //     str[j] = temp2;
    // }
    
    //  
}