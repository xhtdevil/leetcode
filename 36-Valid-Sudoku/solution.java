public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int max = 9;
        for(int i = 0; i < max; i++){
            for(int m = 0; m < max; m++){
                for(int n = m + 1; n < max; n++){
                    if((board[i][m] == board[i][n] && board[i][m] != '.') || (board[m][i] == board[n][i] && board[m][i] != '.')){
                        return false;
                    }
                }
            }
        }
        for(int i = 0; i < max; i++){
            for(int j = 0; j < max; j++){
                for(int m = i + 1 ; m < (i / 3 + 1) * 3; m++){
                    for(int n = j / 3 * 3; n < (j / 3 + 1) * 3; n++){
                       // if(n == j){continue;}
                        if(board[i][j] == board[m][n] && board[i][j] != '.'){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}