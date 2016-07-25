// public class Solution {
//     public boolean isIsomorphic(String s, String t) {
//       // if(s.length() != t. length()){return false;}
//         Map<Character,Integer> sMap = new HashMap<Character,Integer>();
//         Map<Character,Integer> tMap = new HashMap<Character,Integer>();
//         for(int i = 0; i < s.length(); i++){
//             if(sMap.put(s.charAt(i), i) != tMap.put(t.charAt(i), i)) {
//                 return false;
//             }
//         //     if(sMap.get(s.charAt(i)) != tMap.get(t.charAt(i))){
//         //         return false;
//         //     }else{
//         //         sMap.put(s.charAt(i), i);
//         //         tMap.put(t.charAt(i), i);
//         //     }
//         // }
//         }
//         return true;
//     }
// }
public class Solution {
public boolean isIsomorphic(String s, String t) {
Map <Character,Integer> hash1 = new HashMap<Character,Integer>();
Map <Character,Integer> hash2 = new HashMap<Character,Integer>();

        for(int i=0; i<s.length();i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            
            if(hash1.containsKey(ch1)){
                if(t.charAt(hash1.get(ch1)) != t.charAt(i))
                    return false;
            }else{
                if(hash2.containsKey(ch2))
                    return false;
                hash1.put(ch1,i);
                hash2.put(ch2,i);
            }
        }
        return true;
    }
}