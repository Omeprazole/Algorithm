public class L261_GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if(edges == null || edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = initialization(edges);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);
        visited.add(0);

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int each : graph.get(cur)) {
                if(visited.contains(each)) {
                    continue;
                }
                visited.add(each);
                q.offer(each);
            }
        }
        return visited.size() == n;
    }

    private Map<Integer, Set<Integer>> initialization(int[][] edges) {
        Map<Integer, Set<Integer>> res = new HashMap<>();

        for(int i = 0; i <= edges.length; i++) {
            res.put(i, new HashSet<Integer>);
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            res.get(u).add(v);
            res.get(v).add(u);
        }

        return res;
    }
}
