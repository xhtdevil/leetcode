public class Solution {
    public class Cell{
            int height;
            int i;
            int j;
            Cell(){};
            public Cell(int height, int i, int j){
                this.height = height;
                this.i = i;
                this.j = j;
            }
        }
    public int trapRainWater(int[][] heightMap) {
        
        int m = heightMap.length;
        if(m <= 2)return 0;
        int n = heightMap[0].length;
        if(n <= 2)return 0;
        boolean[][] visited = new boolean[m][n];
        Comparator<Cell> comp = new Comparator<Cell>() {
            @Override
            public int compare(Cell a, Cell b) {
                return a.height - b.height;
            }
        };
        Queue<Cell> heap = new PriorityQueue<>(500, comp);
        for(int i = 0; i < m; i++) {
            Cell a1 = new Cell(heightMap[i][0], i, 0);
            visited[i][0] = true;
            heap.add(a1);
            Cell a2 = new Cell(heightMap[i][n - 1], i, n - 1);
            visited[i][n - 1] = true;
            heap.add(a2);
        }
        for(int j = 1; j < n - 1; j++) {
            Cell a1 = new Cell(heightMap[0][j], 0, j);
            visited[0][j] = true;
            heap.add(a1);
            Cell a2 = new Cell(heightMap[m - 1][j], m - 1, j);
            visited[m - 1][j] = true;
            heap.add(a2);
        }
        int ans = 0;
        while(!heap.isEmpty()) {
            Cell cur = heap.peek();
            heap.remove();

            HashSet<Cell> set = new HashSet<Cell>();
            set.add(cur);
            ans += bfs(cur, set, heightMap, heap, visited);
        }
        
        return ans;
    }
    
    private int bfs(Cell cur, Set<Cell> set, int[][] heightMap, Queue<Cell> heap, boolean[][] visited) {
       int rain = 0;
        while(!set.isEmpty()) {
            Set<Cell> tempSet = new HashSet<Cell>();
            for(Cell cell : set){
                int i = cell.i, j = cell.j;

                int[][] a = {{i - 1, j}, {i + 1, j}, {i, j - 1}, {i, j + 1}};
                
                for(int[] x : a) {
                    int g = x[0], h = x[1];
                    
                    if(g >= 0 && g < heightMap.length && h >=0 && h < heightMap[0].length && visited[g][h] == false) {
                        Cell temp = new Cell(heightMap[g][h], g, h);
                        if(heightMap[g][h] >= heightMap[cur.i][cur.j]) {
                            heap.add(temp);
                        }
                        else {
                            rain += cur.height - heightMap[g][h];
                            tempSet.add(temp);
                        }
                        visited[g][h] = true;
                    }
                }
            }
            set = tempSet;
            tempSet = new HashSet<Cell>();
        }
        return rain;
    }
}