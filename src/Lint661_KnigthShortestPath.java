public class Lint661_KnigthShortestPath {
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        int[] xDelta = {1, 1, -1,-1, 2, 2, -2, -2};
        int[] yDelta = {2, -2, 2, -2, 1, -1, 1, -1};

        Queue<Point> q = new LinkedList<>();
        q.offer(source);

        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Point cur = q.poll();
                if(equals(cur, destination)) {
                    return step;
                }
                for(int j = 0; j < 8; j++) {
                    Point newPoint = new Point(cur.x + xDelta[j], cur.y + yDelta[j]);
                    if(isValid(newPoint, grid)) {
                        grid[newPoint.x][newPoint.y] = true;
                        q.offer(newPoint);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private boolean equals(Point A, Point B) {
        return A.x == B.x && A.y == B.y;
    }

    private boolean isValid(Point p, boolean[][] grid) {
        if(p.x < 0 || p.x >= grid.length || p.y < 0 || p.y >= grid[0].length) {
            return false;
        }

        return !grid[p.x][p.y];
    }
}
