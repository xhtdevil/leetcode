public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = turnToMap(prerequisites);
        List<Integer> ans = new ArrayList<Integer>();
        int[] empty = {};
        int[] taken = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            taken[i] = 0;
        }
        for(int i = 0; i < numCourses; i++){
            if(taken[i] == 0){
                taken[i] = 1;
                if(dfs(i, map, taken, ans) == true){
                taken[i] = 2;
                ans.add(i);
                }
                else{
                    return empty;
                }
            }
        }
        return Rev(listTurnToArray(ans));
    }
    
    private Map<Integer, List<Integer>> turnToMap(int[][] pre){
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < pre.length; i++){
            if(!map.containsKey(pre[i][1])){
                map.put(pre[i][1], new ArrayList<Integer>());
            }
            map.get(pre[i][1]).add(pre[i][0]);
        }
        return map;
    }
    
    private boolean dfs(int i, Map<Integer, List<Integer>> map, int[] taken, List<Integer> ans){
        if(!map.containsKey(i)){
            return true;
        }
        for(int j : map.get(i)){
            if(taken[j] == 0){
                taken[j] = 1;
                //boolean canFinish =  dfs(j, map, taken, ans);
                if(dfs(j, map, taken, ans)){
                    taken[j] = 2;
                    ans.add(j);
                }
                else return false;
            }
            else if(taken[j] == 1)return false;
        }
        return true;
    }
    
    private int[] listTurnToArray(List<Integer> list){
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
    
    private int[] Rev(int[] a){
        int[] ans = new int[a.length];
        for(int i = 0; i < a.length; i++){
            ans[i] = a[a.length - 1 - i];
        }
        return ans;
    }
}