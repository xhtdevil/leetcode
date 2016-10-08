public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<>(); 
        int n = buildings.length;
        if(n == 0)return ans;
        int end = buildings[n - 1][1];
        int start = buildings[0][0];
        int j = 0;
        List<int[]> height = new ArrayList<int[]>();
        for(int i = 0; i < n; i++) {
            height.add(new int[]{buildings[i][0], -buildings[i][2]});
            height.add(new int[]{buildings[i][1], buildings[i][2]});
        }
        Collections.sort(height, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]) return a[0] - b[0];
                else return a[1] - b[1];
            }
        });
        // PriorityQueue<Integer> heap2 = new PriorityQueue<Integer>(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer i1, Integer i2) {
        //         return buildings[i2][2] - buildings[i1][2];
        //     }
        // });
        PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>(new Comparator<Integer>() {  
            @Override  
            public int compare(Integer i1, Integer i2) {  
                //return Integer.compare(buildings[i1][1], buildings[i2][1]);  
                return i2 - i1;
            }  
        });  
        
        //int[] max = new int[end];
        //List<int[]> ans = new ArrayList<>();
        int oldHeight = 0;
        for(int[] h : height) {
            //int oldHeight = buildings[heap2.peek()][2];
            if(h[1] < 0) {
                heap1.offer(-h[1]);
                
            }
            else {
                heap1.remove(h[1]);
            }
            // while(j < n && i >= buildings[j][0]) {
            //     heap1.offer(j);
            //     heap2.offer(j);
            //     j++;
            // }
            int newHeight = heap1.isEmpty()? 0 : heap1.peek();
            if(oldHeight != newHeight) {
                int[] newHeightArray = {h[0], newHeight};
                ans.add(newHeightArray);    
                oldHeight = newHeight;
            }
        }
        //int[] endPoint = {end, 0};
        //ans.add(endPoint);
        return ans;
    }
}