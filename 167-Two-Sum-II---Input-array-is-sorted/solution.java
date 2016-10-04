public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = binarySearch(target / 2, numbers, 0, numbers.length - 1);
        int j = i + 1;
        while(i >= 0 || j < numbers.length) {
            if(numbers[i] + numbers[j] == target) {
                int[] ans = {i + 1, j + 1};
                return ans;
            }
            else if(numbers[i] + numbers[j] < target) {
                j++;
            }
            else {
                i--;
            }
            
        }
        return null;
    }
    
    private int binarySearch(int g, int[] numbers, int left, int right) {
        if(left == right) return right;
        int mid = left + (right - left) / 2;
        if(g > numbers[mid]) return binarySearch(g, numbers, mid, right);
        else if(g < numbers[mid]) return binarySearch(g, numbers, left, mid - 1);
        else return mid;
    }
}