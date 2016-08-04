public class Solution {
    public int maxProduct(String[] words) {
        if(words.length == 0)return 0;
        int n = words.length;
        int value[] = new int[n];
        for(int i = 0; i < n; i++){
            value[i] = 0;
            String tem = words[i];
            for(int j = 0; j < words[i].length(); j++){
                value[i] |= 1 << (tem.charAt(j) - 'a');
            }
        }
        int maxPro = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if((value[i] & value[j]) == 0 && words[i].length() * words[j].length() > maxPro){
                    maxPro = words[i].length() * words[j].length();
                }
            }
        }
        return maxPro;
    }
}