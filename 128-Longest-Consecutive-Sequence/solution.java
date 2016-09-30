public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for(int x : nums) {
            if(map.containsKey(x))continue;
            int left = map.containsKey(x - 1)? map.get(x - 1) : 0;
            int right = map.containsKey(x + 1)?  map.get(x + 1) : 0;
            map.put(x, left + right + 1);
            if(max < left + right + 1)max = left + right + 1;
            map.put(x - left, left + right + 1);                    //renew the other side of the consecutive array
            map.put(x + right, left + right + 1);
            // if(map.containsKey(x - 1)) {
            //     count = map.get(x);

            // }
            // else {
            //     count = 1;
            // }if(max < count)max = count;
            // if(map.containsKey(x + 1)) map.put(x + 1, count + map.get(x + 1));
            // else map.put(x + 1, count + 1);
            // if(map.containsKey(x - 1)) map.put(x - 1, count + map.get(x - 1));
            // else map.put(x - 1, count + 1);
            
        }
        return max;
    }
}