public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<>(); 
        int n = buildings.length;
        if(n == 0)return ans;
        int end = buildings[n - 1][1];
        int start = buildings[0][0];
        int j = 0;
        //PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
        // PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>(new Comparator<Integer>() {
        //     @Override
        //     public int compare(int i1, int i2) {
        //         return compare(buildings[i1][1], buildings[i2][1]);
        //     }
        // });
        
        PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return buildings[i2][2] - buildings[i1][2];
            }
        });
        PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>(new Comparator<Integer>() {  
            @Override  
            public int compare(Integer i1, Integer i2) {  
                return Integer.compare(buildings[i1][1], buildings[i2][1]);  
            }  
        });  
        
        //int[] max = new int[end];
        //List<int[]> ans = new ArrayList<>();
        int oldHeight = 0;
        for(int i = start; i <= end && i >= 0; i++) {
            //int oldHeight = buildings[heap2.peek()][2];
            while(!heap1.isEmpty() && buildings[heap1.peek()][1] <= i) {
                int d = heap1.poll();
                heap2.remove(d);
                
            }
            
            while(j < n && i >= buildings[j][0]) {
                heap1.offer(j);
                heap2.offer(j);
                j++;
            }
            int newHeight = heap2.isEmpty()? 0 : buildings[heap2.peek()][2];
            if(oldHeight != newHeight) {
                int[] newHeightArray = {i, newHeight};
                ans.add(newHeightArray);    
                oldHeight = newHeight;
            }
        }
        //int[] endPoint = {end, 0};
        //ans.add(endPoint);
        return ans;
    }
}