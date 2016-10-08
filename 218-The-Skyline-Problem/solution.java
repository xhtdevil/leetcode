public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> ans = new ArrayList<>(); 
        int n = buildings.length;
        if(n == 0)return ans;
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

        PriorityQueue<Integer> heap1 = new PriorityQueue<Integer>(new Comparator<Integer>() {  
            @Override  
            public int compare(Integer i1, Integer i2) {  
                //return Integer.compare(buildings[i1][1], buildings[i2][1]);  
                return i2 - i1;
            }  
        });  
        

        int oldHeight = 0;
        for(int[] h : height) {
            if(h[1] < 0) {
                heap1.offer(-h[1]);
                
            }
            else {
                heap1.remove(h[1]);
            }
            int newHeight = heap1.isEmpty()? 0 : heap1.peek();
            if(oldHeight != newHeight) {
                int[] newHeightArray = {h[0], newHeight};
                ans.add(newHeightArray);    
                oldHeight = newHeight;
            }
        }

        return ans;
    }
}