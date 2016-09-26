public class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        if(m == 0)return;
        int n = board[0].length;
        if(n == 0)return;
        boolean[][] visited = new boolean[m][n];
        for(int i = 1; i < m ; i = i + m - 2) {
            for(int j = 1; j < n ; j = j + n - 2){
                if(board[i][j] == 'o' && visited[i][j] != true){
                    board[i][j] = 'b';
                    visited[i][j] = true;
                    search(board, i, j, visited);
                }
            }
        }
        
        for(int i = 1; i < m ; i++) {
            for(int j = 1; j < n ; j++){
                if(board[i][j] == 'o'){
                    board[i][j] = 'x';
                }
                else if(board[i][j] == 'b') {
                    board[i][j] = 'o';
                }
            }
        }
    }
    
    private void search(char[][] board, int i, int j, boolean[][] visited) {
        //if(i == board.length - 1 || i == 0 || j == board[0].length - 1 || j == 0)return;

        // if(i != 0 && board[i - 1][j] == 'o' && visited[i - 1][j] == false) {
        //     board[i - 1][j] = 'b';
        //     visited[i - 1][j] = true;
        //     search(board, i - 1, j, visited);
        // }
        if(i != board.length - 1 && board[i + 1][j] == 'o' && visited[i + 1][j] == false) {
            board[i + 1][j] = 'b';
            visited[i + 1][j] = true;
            search(board, i + 1, j, visited);
        }
        if(j != board[0].length - 1 && board[i][j + 1] == 'o' && visited[i][j + 1] == false) {
            board[i][j + 1] = 'b';
            visited[i][j + 1] = true;
            search(board, i, j + 1, visited);
        }
        
        if(i != 0 && board[i - 1][j] == 'o' && visited[i - 1][j] == false) {
            board[i - 1][j] = 'b';
            visited[i - 1][j] = true;
            search(board, i - 1, j, visited);
        }
        
        if(j != 0 && board[i][j - 1] == 'o' && visited[i][j - 1] == false) {
            board[i][j - 1] = 'b';
            visited[i][j - 1] = true;
            search(board, i, j - 1, visited);
        }
    }
}