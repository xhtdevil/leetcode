public class Solution {

    public int lengthLongestPath(String input) {
        int max = 0;
        int[] longestPath = new int[input.lastIndexOf("\n") + 3];
        String[] path = input.split("\n");
        if(path.length == 0)return 0;
        longestPath[0] = 0;
        for(int i = 0; i < path.length; i++){
            int level = 0;
            int l = path[i].length();
            int j = 0;
             while(j < path[i].length() && path[i].charAt(j) == '\t'){
                 level++;
                 j++;
                 l--;
             }
            if(path[i].contains(".")){
                max = Math.max(max, longestPath[level] + l);
            }
            else{
                longestPath[level + 1] = longestPath[level] + l + 1;
            }
        }
        return max;
    }
}