public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, sum = 0, start = 0;
        
        for(int i = 0; i < gas.length; i++){
            tank += gas[i] - cost[i];
            sum += tank;
            if(tank < 0){
                tank = 0;
                start = i + 1;
            }
        }
        
        if(sum < 0)return -1;
        else return start;
    }
}