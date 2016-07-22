/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int highb = n;
        int lowb = 1;
        int guessNum = (n + 1) / 2;
        while(true){
            if(guess(guessNum) == 0){
                return guessNum;
            }
            else if(guess(guessNum) == -1){
                highb = guessNum;
                guessNum = (lowb + highb) / 2;
            }
            else if(guess(guessNum) == 1){
                lowb = guessNum;
                guessNum = (lowb + highb) / 2 + 1;
            }
        }
    }
}