public class Lintcode127_TopologicalSort {
    //BFS
    public ArrayList<DirectedGraphNode> topSortBfs(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        HashMap<DirectedGraphNode, Integer> hm = new HashMap<>();
        for(DirectedGraphNode node : graph) {
            for(DirectedGraphNode each : node.neighbors) {
                if(hm.containsKey(each)) {
                    hm.put(each, hm.get(each) + 1);
                } else {
                    hm.put(each, 1);
                }
            }
        }

        Queue<DirectedGraphNode> q = new LinkedList<>();
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        //Add zero dependency node
        for(DirectedGraphNode node : graph) {
            if(!hm.containsKey(node)) {
                q.offer(node);
                res.add(node);
            }
        }

        while(!q.isEmpty()) {
            DirectedGraphNode cur = q.poll();
            for(DirectedGraphNode each : cur.neighbors) {
                int degree = hm.get(each);
                if(degree == 1) {
                    res.add(each);
                    q.offer(each);
                }
                hm.put(each, degree - 1);
            }
        }
        return res;
    }

    //DFS
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        Deque<DirectedGraphNode> stack = new LinkedList<>();
        if(graph == null || graph.size() == 0) {
            return res;
        }

        Set<DirectedGraphNode> visited = new HashSet<>();

        for(DirectedGraphNode each : graph) {
            if(!visited.contains(each)) {
                helper(each, graph, stack, visited);
            }
        }

        while(!stack.isEmpty()) {
            res.add(stack.pollFirst());
        }
        return res;
    }

    private void helper(DirectedGraphNode node, ArrayList<DirectedGraphNode> graph, Deque<DirectedGraphNode> stack, Set<DirectedGraphNode> visited) {
        visited.add(node);
        if(node.neighbors == null) {
            stack.offerFirst(node);
            return;
        }

        for(DirectedGraphNode each : node.neighbors) {
            if(!visited.contains(each)) {
                helper(each, graph, stack, visited);
            }
        }
        stack.offerFirst(node);
    }
}
