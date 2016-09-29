public class Solution {
    Map<List<Integer>, Integer> map = new HashMap<List<Integer>, Integer>();
    
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length == 0)return 0;
        for(int i : nums) {
            list.add(i);
        }
        return help(list);
    }
    
    private int help(List<Integer> list) {
        if(list.size() == 1)return list.get(0);
        if(map.containsKey(list))return map.get(list);
        int max = Integer.MIN_VALUE;
        int res = 0;
        for(int i = 0; i < list.size(); i++) {
            if(i == 0) {
                res = list.get(0) * list.get(1);
                int old = list.get(0);
                list.remove(0);
                res += help(list);
                list.add(0, old);
            }
            else if(i == list.size() - 1) {
                res = list.get(i) * list.get(i - 1);
                int old = list.get(i);
                list.remove(i);
                res += help(list);
                list.add(i, old);
            }
            else {
                res = list.get(i - 1) * list.get(i) * list.get(i + 1);
                int old = list.get(i);
                list.remove(i);
                res += help(list);
                list.add(i, old);
            }
            if(max < res)max = res;
        }
        map.put(list, max);
        return max;
    }
}