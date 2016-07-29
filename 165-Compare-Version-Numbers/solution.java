public class Solution {
    public int compareVersion(String version1, String version2) {
        String v1[] = version1.split("\\.");            //notice "\\." for split
        String v2[] = version2.split("\\.");
        int vlen1 = v1.length; 
        int vlen2 = v2.length;
        for(int i = v1.length - 1; i > 0; i--){
            if(Integer.valueOf(v1[i]) == 0){vlen1--;}
            else break;
        }
        for(int i = v2.length - 1; i > 0; i--){
            if(Integer.valueOf(v2[i]) == 0){vlen2--;}
            else break;
        }
        int vl = Math.min(vlen1, vlen2);
        
        for(int i = 0; i < vl; i++){
            if(Integer.valueOf(v1[i]) > Integer.valueOf(v2[i]))return 1;
            else if(Integer.valueOf(v1[i]) < Integer.valueOf(v2[i]))return -1;
        }
        if(vlen1 > vlen2)return 1;
        else if(vlen1 < vlen2)return -1;
        else return 0;
    }
}