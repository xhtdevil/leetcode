public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(edges.length == 0){
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < n; i++){
                list.add(i);
            }
            return list;
        }
        //take off leaves to find the root of MHT
        
        Map<Integer, List<Integer>> adj = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < edges.length; i++){
            if(adj.containsKey(edges[i][0])){
                adj.get(edges[i][0]).add(edges[i][1]);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(edges[i][1]);
                adj.put(edges[i][0], list);
            }
            if(adj.containsKey(edges[i][1])){
                adj.get(edges[i][1]).add(edges[i][0]);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(edges[i][0]);
                adj.put(edges[i][1], list);
            }
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        for(int i: adj.keySet()){
            if(adj.get(i).size() == 1){
                leaves.add(i);
            }
        }
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for(int i = 0; i < leaves.size(); i++){
                int newL = adj.get(leaves.get(i)).get(0);
                for(int j = 0; j < adj.get(newL).size(); j++){
                    if(adj.get(newL).get(j) == leaves.get(i))adj.get(newL).remove(j);
                }
                if(adj.get(newL).size() == 1)newLeaves.add(newL);
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}