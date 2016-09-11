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
       HashSet<UndirectedGraphNode> rec = new HashSet<UndirectedGraphNode>();
       return help(node, rec);
       //undirectedGraphNode depthFirst(node); 
        
    }
    
    private UndirectedGraphNode help(undirectedGraphNode node, HashSet<UndirectedGraphNode> rec){
        if(node == null)return null;
        undirectedGraphNode ans = new undirectedGraphNode(node.val);
        
        for(int i = 0; i < node.neighbors.size(); i++){
            if(rec.add(node.neighbors.get(i))){
                ans.neighbors.add(help(node.neighbors.get(i)));
            }
        }
        return ans;
    }
}