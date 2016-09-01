public class Solution {
    //Use HashMap. Time exceed
    // public List<List<Integer>> permuteUnique(int[] nums) {
    //     //HashSet<List<Integer>> set = new HashSet<ArrayList<Integer>>();
    //     return helper(nums, nums.length);
    // }
    
    // private List<List<Integer>> helper(int[] nums, int n){
    //     List<List<Integer>> curResult = new ArrayList<List<Integer>>();
    //     if(n == 0){
    //         curResult.add(new LinkedList<Integer>());
    //         return curResult;
    //     }
    //     List<List<Integer>> lastResult = helper(nums, n - 1);
    //     HashSet<List<Integer>> set = new HashSet<List<Integer>>();
    //     for(int i = 0; i < lastResult.size(); i++){
    //         List<Integer> list = new LinkedList<Integer>(lastResult.get(i));
    //         for(int j = 0; j <= list.size(); j++){
    //             list.add(j, nums[n - 1]);
    //             if(set.add(list)){
    //                 curResult.add(list);
    //             }
    //         }
    //     }
    //     return curResult;
    // }
     public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0)
            return result;
        List<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        
        Arrays.sort(num);
        helper(result, list, visited, num);
        return result;
    }
    
    public void helper(List<List<Integer>> result, List<Integer> list, int[] visited, int[] num) {
        if(list.size() == num.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < num.length; i++) {
            if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0)){
                continue;
        /*
            上面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，
            我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果
            当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就
            不应该让后面的2使用。
        */
            }
            visited[i] = 1;
            list.add(num[i]);
            helper(result, list, visited, num);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    } 
    
   
    
}