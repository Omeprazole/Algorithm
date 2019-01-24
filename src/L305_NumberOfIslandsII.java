public class L305_NumberOfIslandsII {

    int count;

    private int find(int i, int[] parent) {
        if(i != parent[i]) {
            parent[i] = find(parent[i], parent);
        }
        return parent[i];
    }

    private void union(int x, int y, int[] rank, int[] parent) {
        int rootx = find(x, parent);
        int rooty = find(y, parent);
        if(rootx == rooty) {
            return;
        }

        if(rank[rootx] > rank[rooty]) {
            parent[rooty] = rootx;
        } else if(rank[rootx] < rank[rooty]) {
            parent[rootx] = rooty;
        } else {
            parent[rooty] = rootx;
            rank[rootx] += 1;
        }
        count--;
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        int[] rank = new int[m * n];
        char[][] grid = new char[m][n];

        for(int i = 0; i < m * n; i++) {
            parent[i] = -1;
        }

        List<Integer> res = new ArrayList<>();
        if(positions == null || positions.length == 0 || positions[0].length == 0) {
            return res;
        }

        count = 0;
        int[] deltaX = {0, 0, 1, -1};
        int[] deltaY = {1, -1, 0, 0};

        grid[positions[0][0]][positions[0][1]] = '1';
        for(int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];

            parent[x * n + y] = x * n + y;
            count++;

            for(int j = 0; j < 4; j++) {
                int neigborX = x + deltaX[j];
                int neigborY = y + deltaY[j];

                if(neigborX >= 0 && neigborX < m && neigborY >= 0 && neigborY < n && parent[neigborX * n + neigborY] != -1) {
                    union(x * n + y, neigborX * n + neigborY, rank, parent);
                }
            }
            int tmp = count;
            res.add(tmp);

        }
        return res;
    }
}
