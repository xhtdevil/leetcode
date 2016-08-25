public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length <= 0)return 0;
        Arrays.sort(citations);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int h = 0;
        for(int i = citations.length - 1; i >= 0; i--){
            if(citations[i] >= citations.length - i && ((i >= 1 && citations[i - 1] <= citations.length - i) || i == 0)){
                return citations.length - i;
            }
            // h += map.get(citations[i]);
            // map.put(citations[i], h + )
            // if(map.containsKey(citations[i]))map.get(citations[i])
        }
        return 0;
    }
}