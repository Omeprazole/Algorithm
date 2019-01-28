public class Lint574_BuildPostOffice {
    /**
     * @param grid: a 2D grid
     * @return: An integer
     */
    public int EMPTY = 0;
    public int HOUSE = 1;

    public int[] deltaX = {0, 1, -1, 0};
    public int[] deltaY = {1, 0, 0, -1};
    public class Coords {
        int x, y;
        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int shortestDistance(int[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;

        List<Coords> houses = getCoords(grid, HOUSE);
        int[][] distances = new int[m][n];
        int[][] visitedNum = new int[m][n];

        for(Coords house : houses) {
            bfs(house, distances, visitedNum, grid);
        }

        int shortest = Integer.MAX_VALUE;
        List<Coords> empties = getCoords(grid, EMPTY);
        for(Coords empty : empties) {
            if(visitedNum[empty.x][empty.y] != houses.size()) {
                continue;
            }
            shortest = Math.min(shortest, distances[empty.x][empty.y]);
        }

        if(shortest == Integer.MAX_VALUE) {
            return -1;
        }
        return shortest;
    }

    private List<Coords> getCoords(int[][] grid, int type) {
        List<Coords> res = new ArrayList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == type) {
                    res.add(new Coords(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(Coords house, int[][] distances, int[][] visitedNum, int[][] grid) {
        Queue<Coords> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        q.offer(house);
        visited[house.x][house.y] = true;

        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            steps++;
            for(int index = 0; index < size; index++) {
                Coords cur = q.poll();
                for(int num = 0; num < 4; num++) {
                    int i = cur.x + deltaX[num];
                    int j = cur.y + deltaY[num];
                    Coords neighor = new Coords(i, j);
                    if(i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                        q.offer(neighor);
                        visited[i][j] = true;
                        distances[i][j] += steps;
                        visitedNum[i][j]++;
                    }
                }
            }
        }
    }
}
