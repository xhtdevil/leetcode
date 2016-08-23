public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        return matrixBinarySearch(0, 0, m - 1, n - 1, matrix, target);
    }
    
    private boolean matrixBinarySearch(int x1, int y1, int x2, int y2, int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int start = x1 * n + y1, end = x2 * n + y2;
        if(start <= end){
            int mid = start + (end - start) / 2;
            int midx = mid / n, midy = mid % n;
            if(target > matrix[midx][midy]){
                return matrixBinarySearch((mid + 1) / n, (mid + 1) % n, x2, y2, matrix, target);
            }
            else if(target < matrix[midx][midy]){
                return matrixBinarySearch(x1, y1, (mid - 1) / n, (mid - 1) % n, matrix, target);
            }
            else{
                return true;
            }
        }
        return false;
        
    }
}