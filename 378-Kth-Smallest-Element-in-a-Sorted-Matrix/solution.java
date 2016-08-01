public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(10000, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        if(matrix.length == 0 || k == 0){
            return 0;
        }
        heap.offer(new int[]{matrix[0][0], 0, 0}); 
        int peek[] = new int[3];
        
        while(k > 0){
            k--;
            peek = heap.poll();
            if(peek[1] + 1 < matrix.length){
                heap.offer(new int[]{matrix[peek[1] + 1][peek[2]], peek[1] + 1, peek[2]});
            }
            if(peek[2] + 1 < matrix[0].length && peek[1] == 0){
                heap.offer(new int[]{matrix[peek[1]][peek[2] + 1], peek[1], peek[2] + 1});
            }
        }
        return peek[0];
    }
}