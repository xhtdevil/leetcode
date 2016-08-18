public class Solution {
    //combine(n, k) = combine(n - 1, k) + combine(n - 1, k - 1).add(n)
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(k > n || k < 0){return ans;}
        if(k == 0){
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        ans = combine(n - 1, k - 1);
        for(int i = 0; i < ans.size(); i++){
            ans.get(i).add(n);
        }
        ans.addAll(combine(n - 1, k));
        return ans;
    }
}