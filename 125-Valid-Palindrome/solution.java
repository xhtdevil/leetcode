public class Solution {
    public boolean isPalindrome(String s) {
        // String alphaOnly = "";
        // s = s.toLowerCase();
        // for(int i = 0; i < s.length(); i++){
        //     if(s.charAt(i) <= 'z' && s.charAt(i) >= 'a' || s.charAt(i) <= '9' && s.charAt(i) >= '0'){
        //         alphaOnly = alphaOnly + s.charAt(i);
        //     }
        // }
        // if(alphaOnly.length() == 0)return true;
        // for(int i = 0; i < alphaOnly.length() / 2; i++){
        //     if(alphaOnly.charAt(i) != alphaOnly.charAt(alphaOnly.length() - i - 1))return false;
        // }
        // return true;
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
}