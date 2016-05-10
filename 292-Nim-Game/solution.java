public class Solution {
    public boolean canWinNim(int n) {
        if((n mod 4) == 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}