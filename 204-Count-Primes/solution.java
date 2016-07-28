public class Solution {
    public int countPrimes(int n) {
        if(n < 3){return 0;}
        boolean[] notPrime = new boolean[n];               //record prime 
        int count  = n / 2;                             //ignore even number
        for(int i = 3; i * i < n; i += 2){              //loop all odd number
            if(notPrime[i]){continue;}
            for(int j = i * i; j < n; j += 2 * i){      //delete those notprime odd number
                if(!notPrime[j]){
                    count--;
                    notPrime[j] = true;
                }
            }
        }
        return count;
    }
}