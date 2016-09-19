public class Solution {
    public List<String> restoreIpAddresses(String s) {
        int count = 4;
        List<String> ans = new ArrayList<String>();
        if(s.length() < count || s.length() > count * 3)return ans;
        String IP = "";
        help(s, count, ans, IP);
        return ans;
    }
    
    private void help(String s, int count, List<String> ans, String IP){
        if(count == 0 && s.length() == 0){
            //IP += "." + s;
            ans.add(new String(IP));
        }
        else if( s.length() < count || s.length() > count * 3 )return;
        else if(count >= 1 && s.length() != 0){
            if(s.charAt(0) == '0'){
                String formIp = IP;
                if(count == 4)IP += "0";
                else IP += ".0";
                help(s.substring(1), count - 1, ans, IP);
                IP = formIp;
            }
            else{
                for(int i = 1; i <= 3 && i < s.length() + 1; i++){
                    String sub = s.substring(0, i);
                    //if(Integer.valueOf(sub) <= 255 && s.length() >= count && s.length() <= count * 3){
                    if(Integer.parseInt(sub) <= 255){
                    //if(true){
                        String formIp = IP;
                        if(count == 4)IP += sub;
                        else {
                            IP = IP + ".";
                            IP = IP + sub;
                        }
                        help(s.substring(i), count - 1, ans, IP);
                        IP = formIp;
                    }
                }
            }
        }
    }
}