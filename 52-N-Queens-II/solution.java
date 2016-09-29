public class Solution {

    public int totalNQueens(int n) {
        if(n == 0)return 0;
        int[] colIndex = new int[n];
        for(int i = 0; i < n; i++) {
            colIndex[i] = i;
        }
        
        return perm(colIndex, 0);
    }
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private int perm(int[] a, int k) {
        
        if(k == a.length - 1) {
            if(check(a)) {
                return 1;
            }
            else return 0;
        }
        int count = 0;
        for(int i = k; i < a.length; i++) {
            swap(a, k, i);
            count += perm(a, k + 1);
            swap(a, k, i);
        }
        return count;
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