public class Lint531_SixDegrees {
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        // write your code here
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        q.offer(s);
        visited.add(s);
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                UndirectedGraphNode cur = q.poll();
                if(cur == t) {
                    return step;
                }
                for(UndirectedGraphNode each : cur.neighbors) {
                    if(!visited.contains(each)) {
                        if(cur == t) {
                            return ++step;
                        }
                        q.offer(each);
                        visited.add(each);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
