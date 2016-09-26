public class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        if(m <= 1)return;
        int n = board[0].length;
        if(n <= 1)return;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m ; i = i + m - 1) {
            for(int j = 0; j < n ; j = j + n - 1){
                if(board[i][j] == 'O' && visited[i][j] != true){
                    board[i][j] = 'b';
                    visited[i][j] = true;
                    search(board, i, j, visited);
                }
            }
        }
        
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                else if(board[i][j] == 'b') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void search(char[][] board, int i, int j, boolean[][] visited) {
       
        if(i != board.length - 1 && board[i + 1][j] == 'O' && visited[i + 1][j] == false) {
            board[i + 1][j] = 'b';
            visited[i + 1][j] = true;
            search(board, i + 1, j, visited);
        }
        if(j != board[0].length - 1 && board[i][j + 1] == 'O' && visited[i][j + 1] == false) {
            board[i][j + 1] = 'b';
            visited[i][j + 1] = true;
            search(board, i, j + 1, visited);
        }
        
        if(i != 0 && board[i - 1][j] == 'O' && visited[i - 1][j] == false) {
            board[i - 1][j] = 'b';
            visited[i - 1][j] = true;
            search(board, i - 1, j, visited);
        }
        
        if(j != 0 && board[i][j - 1] == 'O' && visited[i][j - 1] == false) {
            board[i][j - 1] = 'b';
            visited[i][j - 1] = true;
            search(board, i, j - 1, visited);
        }
    }
}