public class L200_NumberOfIslands {
    class Coord {
        int x;
        int y;
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        int[] coorX = {1, -1, 0, 0};
        int[] coorY = {0, 0, 1, -1};
        visited[x][y] = true;
        Queue<Coord> q = new LinkedList<>();
        q.add(new Coord(x, y));
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Coord cur = q.poll();
                for(int j = 0; j < 4; j++) {
                    int curx = cur.x + coorX[j];
                    int cury = cur.y + coorY[j];
                    if(curx >= 0 && curx < grid.length && cury >= 0 && cury < grid[0].length && grid[curx][cury] == '1' && !visited[curx][cury]) {
                        q.add(new Coord(curx, cury));
                        visited[curx][cury] = true;
                    }
                }
            }
        }
    }
}
