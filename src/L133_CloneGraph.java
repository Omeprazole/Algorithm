public class L133_CloneGraph {
    //BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;

        List<UndirectedGraphNode> nodes = getNodes(node);

        HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
        for(UndirectedGraphNode each : nodes) {
            UndirectedGraphNode newNode = new UndirectedGraphNode(each.label);
            hm.put(each, newNode);
        }

        for(UndirectedGraphNode each : nodes) {
            UndirectedGraphNode newNode = hm.get(each);
            for(UndirectedGraphNode neighbor : each.neighbors) {
                UndirectedGraphNode newNei = hm.get(neighbor);
                newNode.neighbors.add(newNei);
            }
        }

        return hm.get(node);
    }

    private List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        List<UndirectedGraphNode> res = new ArrayList<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        res.add(node);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                UndirectedGraphNode cur = q.poll();
                for(UndirectedGraphNode each : cur.neighbors) {
                    if(!visited.contains(each)) {
                        q.offer(each);
                        visited.add(each);
                        res.add(each);
                    }
                }
            }
        }
        return res;
    }

    //DFS
    private HashMap<UndirectedGraphNode, UndirectedGraphNode> hm = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return node;
        }

        if(!hm.containsKey(node)) {
            hm.put(node, new UndirectedGraphNode(node.label));
            UndirectedGraphNode newNode = hm.get(node);
            for(UndirectedGraphNode neighbor : node.neighbors) {
                newNode.neighbors.add(cloneGraph(neighbor));
            }
            return newNode;
        } else {
            return hm.get(node);
        }
    }
}
