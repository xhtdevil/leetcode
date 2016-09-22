public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0)return true;
        int m = board.length;
        int n = board[0].length;
        if(m == 0 || n == 0)return false;
        boolean[][] rec = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    rec[i][j] = true;
                     if(help(board, word.substring(1), rec, i, j) == true)return true;
                     rec[i][j] = false;
                }
            }
        }
        return false;
    }
    
    private boolean help(char[][] board, String word, boolean[][] rec, int i, int j){
        if(word.length() == 0)return true;
        if(i >= 1 && board[i - 1][j] == word.charAt(0) && rec[i - 1][j] == false){
            rec[i - 1][j] = true;
            if(help(board, word.substring(1), rec, i - 1, j) == true)return true;
            rec[i - 1][j] = false;
        }
        if(j >= 1 && board[i][j - 1] == word.charAt(0) && rec[i][j - 1] == false){
            rec[i][j - 1] = true;
            if(help(board, word.substring(1), rec, i, j - 1) == true)return true;
            rec[i][j - 1] = false;
        }
        if(i < board.length - 1 && board[i + 1][j] == word.charAt(0) && rec[i + 1][j] == false){
            rec[i + 1][j] = true;
            if(help(board, word.substring(1), rec, i + 1, j) == true)return true;
            rec[i + 1][j] = false;
        }
        if(j < board[0].length - 1 && board[i][j + 1] == word.charAt(0) && rec[i][j + 1] == false){
            rec[i][j + 1] = true;
            if(help(board, word.substring(1), rec, i, j + 1) == true)return true;
            rec[i][j + 1] = false;
        }
        return false;
    }
}