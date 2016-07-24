public class Solution {
    public String getHint(String secret, String guess) {
        int bull = 0, cow = 0;
        int max = secret.length();
        Set<Integer> guessSet = new HashSet<Integer>();
        Set<Integer> secretSet = new HashSet<Integer>();
        for(int i = 0; i < max; i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bull++;
                guessSet.add(i);
                secretSet.add(i);
            }
        }
        for(int i = 0; i < max; i++){
            for(int j = 0; j < max; j++){
                if(secret.charAt(i) != guess.charAt(j) || i == j){}
                else if(!guessSet.contains(i) && !secretSet.contains(j)){
                    cow++;
                    guessSet.add(i);
                    secretSet.add(j);
                }
            }
        }
        return bull + "A" + cow + "B";
       
    }
}