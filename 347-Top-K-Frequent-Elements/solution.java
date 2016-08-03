public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int a = map.get(nums[i]) + 1;
                map.put(nums[i], a);
            }
            else{
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(10000, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                return b[1] - a[1];    
            }
        });
        for(Integer i : map.keySet()){
            int[] a = {i, map.get(i)};
            heap.offer(a);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < k; i++){
            int[] a = heap.poll();
            list.add(a[0]);
        }
        return list;
    }
}