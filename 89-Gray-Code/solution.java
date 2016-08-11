public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        for(int i = 1; i < (1 << n); i <<= 1 ){
            for(int j = list.size() - 1; j >= 0; j--){
                list.add(list.get(j)|i);
            }
        }
        return list;
    }
}