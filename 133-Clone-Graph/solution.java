/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
       HashMap<Integer, UndirectedGraphNode> rec = new HashMap<Integer, UndirectedGraphNode>();
       return help(node, rec);
       //undirectedGraphNode depthFirst(node); 
        
    }
    
    private UndirectedGraphNode help(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> rec){
        if(node == null)return null;
        if(rec.containsKey(node.label)){
            return rec.get(node.label);
        }
        UndirectedGraphNode ans = new UndirectedGraphNode(node.label);
        rec.put(node.label, ans);
        for(int i = 0; i < node.neighbors.size(); i++){

                ans.neighbors.add(help(node.neighbors.get(i), rec));
        }
        return ans;
    }
}