public class Solution {
    //Failure [JFK abc] [JFK def] [abc JFK]
    // public List<String> findItinerary(String[][] tickets) {
        
    //     List<String> ans = new ArrayList<String>();
    //     if(tickets.length == 0)return ans;
        
    //     Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
    //     for(int i = 0; i < tickets.length; i++){
    //         visited.put(i, false);
    //     }
        
    //     ans.add("JFK");
    //     String from = "JFK", to = "ZZZ";
        
    //     while(true){
    //         int mark = -1;
    //         for(int i = 0; i < tickets.length; i++){
    //             if(!visited.get(i) && tickets[i][0].equals(from) && tickets[i][1].compareTo(to) <= 0){
    //                 mark = i;
    //                 to = tickets[i][1];
    //             }
    //         }
    //         if(mark == -1)break;
    //         visited.put(mark, true);
    //         ans.add(to);
    //         from = to;
    //         to = "ZZZ";
    //     }
    //     return ans;
    // }
    Map<String, PriorityQueue<String>> flight = new HashMap<String, PriorityQueue<String>>();
    List<String> ans = new LinkedList<String>();
    
    public List<String> findItinerary(String[][] tickets){
        //List<String> ans = new ArrayList<String>();
        for(String[] str : tickets){
            if(!flight.containsKey(str[0])){
                flight.put(str[0], new PriorityQueue());
            }
            flight.get(str[0]).add(str[1]);
        }
        helper("JFK");
        return ans;
    }
    
    private void helper(String s){
        while(flight.containsKey(s) && !flight.get(s).isEmpty()){
            helper(flight.get(s).poll());
        }
        ans.add(0, s);
    }
}