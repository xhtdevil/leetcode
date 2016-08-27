public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        //T[n+1] = max{ 1 + T[i] if a[n+1] mod a[i] == 0 else 1 }
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        int[] subSet= new int[nums.length];
        int[] parent= new int[nums.length];
        subSet[0] = 1;
        int max = 0;
        int maxi = 0;
        for(int i = 1; i < nums.length; i++){
            subSet[i] = 1;
            for(int j = 0; j < i; j++){
                if((nums[i] % nums[j] == 0) && (subSet[j] + 1 > subSet[i])){
                    subSet[i] = subSet[j] + 1;
                    parent[i] = j;
                }
            }
            if(max < subSet[i]){
                max = subSet[i];
                maxi = i;
            }
        }
        for(int i = 0; i < max; i++){
            ans.add(nums[maxi]);
            maxi = parent[maxi];
        }
        return ans;
    }
}