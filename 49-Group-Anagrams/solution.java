public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)return new ArrayList<List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            String sorted = stringSort(strs[i]);
            
            if(map.containsKey(sorted)){
                map.get(sorted).add(strs[i]);
            }
            
            else{
                List<String> strsList = new ArrayList<String>();
                strsList.add(strs[i]);
                map.put(sorted, strsList);
            }
            
        }
        for(String s: map.keySet()){
            result.add(map.get(s));
        }
        return result;
    }
    
    private String stringSort(String strs){
        if(strs.length() == 0)return strs;
        char[] c = strs.toCharArray();
        String result = "";
        for(int i = 0; i < strs.length(); i++){
            for(int j = i; j < strs.length(); j++){
                int dif = c[j] - 'a';
                if(dif < c[i] - 'a'){
                    char temp = c[j];
                    c[j] = c[i];
                    c[i] = temp;
                }
            }
            result = result + c[i];
        }
        return result;
    }
}