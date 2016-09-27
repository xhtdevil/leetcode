public class Solution {
    public void solve(char[][] board) {
        
        int m = board.length;
        if(m <= 1)return;
        int n = board[0].length;
        if(n <= 1)return;
        Queue<Point> q = new LinkedList<Point>();
            for(int j = 0; j < n ; j++){
                if(board[0][j] == 'O'){
                    q.add(new Point(0, j));
                    //BFS(board, q);
                }
                if(board[m - 1][j] == 'O'){
                    q.add(new Point(m - 1, j));
                    //BFS(board, q);
                }
            }

        
         for(int i = 0; i < m ; i++) {
                if(board[i][0] == 'O'){

                    q.add(new Point(i, 0));
                    //BFS(board, q);
                }
                if(board[i][n - 1] == 'O'){

                    q.add(new Point(i, n - 1));
                    //BFS(board, q);
                }
        }
        
        while(!q.isEmpty()){
            Point pair1 = q.poll();

             int i = pair1.x, j = pair1.y;
            board[i][j] = 'b';

            if(i > 0 && board[i - 1][j] == 'O') {

                q.add(new Point(i - 1, j));
            }
            if(i < board.length - 1 && board[i + 1][j] == 'O') {

                q.add(new Point(i + 1, j));

            }
            if(j > 0 && board[i][j - 1] == 'O') {

                q.add(new Point(i, j - 1));

            }
            if(j < board[0].length - 1 && board[i][j + 1] == 'O') {

                q.add(new Point(i, j + 1));

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
    

    
    private void BFS(char[][] board, Queue<Point> q) {
        while(!q.isEmpty()){
            Point pair1 = q.poll();

             int i = pair1.x, j = pair1.y;
            board[i][j] = 'b';

            if(i > 0 && board[i - 1][j] == 'O') {

                q.add(new Point(i - 1, j));
            }
            if(i < board.length - 1 && board[i + 1][j] == 'O') {

                q.add(new Point(i + 1, j));

            }
            if(j > 0 && board[i][j - 1] == 'O') {

                q.add(new Point(i, j - 1));

            }
            if(j < board[0].length - 1 && board[i][j + 1] == 'O') {

                q.add(new Point(i, j + 1));

            }
            
        }
        
    }
}