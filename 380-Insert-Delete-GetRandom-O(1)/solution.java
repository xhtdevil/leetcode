public class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> nums;
    java.util.Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer, Integer>();
        nums = new ArrayList<Integer>();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if( map.containsKey(val) == true) return false;
        else {
            map.put(val, nums.size());
            nums.add(val);
        }
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if( map.containsKey(val) == false ) return false;
        else {
            int i = map.get(val);
            if (i != nums.size() - 1) {
                int temp = nums.get(nums.size() - 1);
                nums.set(i, temp);
                map.put(temp, i);
            }
            nums.remove(nums.size() - 1);
            map.remove(val);
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        rand = new java.util.Random();
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */