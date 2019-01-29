public class Lint618_SearchGraphNodes {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // write your code here
        if(values.get(node) == target) {
            return node;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        visited.add(node);
        q.add(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode cur = q.poll();
            for(UndirectedGraphNode each : cur.neighbors) {
                if(!visited.contains(each)) {
                    if(values.get(each) == target) {
                        return each;
                    }
                    q.offer(each);
                    visited.add(each);
                }
            }
        }
        return null;
}
