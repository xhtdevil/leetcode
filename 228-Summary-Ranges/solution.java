public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<String>();
        if(nums.length == 0)return ans;
        ans.add(Integer.toString(nums[0]));
        for(int i = 1; i < nums.length; i++){
            String s = ans.get(ans.size() - 1);
            if(s.contains("->")){
                int j = s.indexOf(">");
                String lastNum = s.substring(j + 1);
                if(nums[i] - Integer.valueOf(lastNum) == 1){
                    String temp = s.substring(0, j + 1) + nums[i];
                    ans.remove(ans.size() - 1);
                    ans.add(temp);
                }
                else{
                    ans.add(nums[i] + "");
                }
            }
            else{
                int lastNum = Integer.valueOf(s);
                if(nums[i] - lastNum == 1){
                    ans.remove(ans.size() - 1);
                    ans.add(lastNum + "->" + nums[i]);
                }
                else{
                    ans.add(nums[i] + "");
                }
            }
        }
        return ans;
    }
}