public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        if(m == 0 || n == 0)return;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int lives = isLife(board, m, n, i, j);
                if(board[i][j] == 0 && lives == 3){board[i][j] = 2;}
                if(board[i][j] == 1 && lives >= 2 && lives <=3){board[i][j] = 3;}
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    private int isLife(int[][] board, int m, int n, int i, int j){
        int lives = 0;
        for(int x = Math.max(0, i - 1); x <= Math.min(i + 1, m - 1); x++){
            for(int y = Math.max(0, j - 1); y <= Math.min(j + 1, n - 1); y++){
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}