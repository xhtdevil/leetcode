public class Solution {
    public List<List<Integer>> ans = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k == 0 || n == 0)return null;
        List<Integer> list = new ArrayList<Integer>();
        combination(k, n, list, 0);
        return ans;
    }
    
    public void combination(int k, int n, List<Integer> list, int last){
        if(k == 0 && n == 0){
            List<Integer> finish =new ArrayList<Integer>();
            for(int i = 0; i < list.size(); i++){
                finish.add(list.get(i));
            }
            ans.add(finish);
            //list = new ArrayList<Integer>();
        }
        else if(k > 0 && n > 0){
             for(int i = last + 1; i < Math.min(n + 1,10); i++){
                 list.add(i);
                 combination(k - 1, n - i, list, i);
                 list.remove(list.size() - 1);
             }
        }
    } 
}