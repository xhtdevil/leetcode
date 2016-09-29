public class Solution {
    
    List<int[]> ans = new ArrayList<int[]>();
    
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(n == 0) {
            res.add(new ArrayList<String>());
            return res;
            
        }
        int[] colIndex = new int[n];
        
        for(int i = 0; i < n; i++) {
            colIndex[i] = i;
        }

        perm(colIndex, 0);
        
        
        for(int[] a : ans){
            List<String> list = new ArrayList<String>();
            for(int i = 0; i < n; i++) {
                String str = "";
                for(int j = 0; j < n; j++) {
                    if(a[i] == j)str += "Q";
                    else str += ".";
                }
                list.add(str);
            }
            res.add(list);
        }
        return res;
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private void perm(int[] a, int k) {
        if(k == a.length - 1) {
            if(check(a)) {
                int[] b = new int[a.length];            //must copy the array from int[] a because a varies during the recursion
                for(int i = 0; i < a.length; i++) {
                    b[i] = a[i];
                }
                ans.add(b);
            }
            return;
        }
        for(int i = k; i < a.length; i++) {
            swap(a, k, i);
            perm(a, k + 1);
            swap(a, k, i);
        }
    }
    
    private boolean check(int[] a) {                    //limitating condition of backtracking 
        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(Math.abs(a[j] - a[i]) == j - i)return false;
            }
        }
        return true;
    }
}