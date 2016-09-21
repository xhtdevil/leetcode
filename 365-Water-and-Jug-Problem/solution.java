public class Solution {
    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    public boolean canMeasureWater(int x, int y, int z) {
       if(z > x + y)return false;
       if(z == x || z == y || z == x + y || z == 0 || z % GCD(x, y) == 0)return true;
       else return false;
    }
    
    private int GCD(int a, int b){
        while(b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}