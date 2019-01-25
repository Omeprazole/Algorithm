public class Lint598_ZombieInMatrix {
    public class Coords {
        int x;
        int y;
        public Coords(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int zombie(int[][] grid) {
        // write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }

        int people = 0;
        Queue<Coords> q = new LinkedList<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) {
                    people++;
                }

                if(grid[i][j] == 1) {
                    q.offer(new Coords(i, j));
                }
            }
        }
        if(people == 0) return 0;

        int[] deltaX = {0, 0, 1, -1};
        int[] deltaY = {1, -1, 0, 0};
        int days = 0;
        while(!q.isEmpty()){
            days++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Coords cur = q.poll();
                for(int j = 0; j < 4; j++) {
                    int x = cur.x + deltaX[j];
                    int y = cur.y + deltaY[j];
                    if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0) {
                        grid[x][y] = 1;
                        q.offer(new Coords(x, y));
                        people--;
                    }
                    if(people == 0) {
                        return days;
                    }
                }
            }
        }
        return -1;
    }
}
