public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return quardSearch(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, target);
    }
    
    private boolean quardSearch(int[][] matrix, int x1, int y1, int x2, int y2, int target){
        if(x1 >= matrix.length || y1 >= matrix[0].length || target > matrix[x2][y2] || target < matrix[x1][y1])
        return false;
        if(x1 == x2 && y1 == y2){
            if(target == matrix[x1][y1])return true;
            else return false;
        }
            int midX = (x1 + x2) / 2;
            int midY = (y1 + y2) / 2;
            if(matrix[midX][midY] == target)return true;
        else if(matrix[midX][midY] > target)
        return quardSearch(matrix,       x1,       y1, midX, midY, target) ||
               quardSearch(matrix, midX + 1,       y1,   x2, midY, target) ||
               quardSearch(matrix,       x1, midY + 1, midX,   y2, target);
    else
        return quardSearch(matrix, midX + 1,       y1,   x2, midY, target) ||
               quardSearch(matrix,       x1, midY + 1, midX,   y2, target) ||
               quardSearch(matrix, midX + 1, midY + 1,   x2,   y2, target);
    }
}