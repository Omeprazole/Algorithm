public class L773_SlidingWindow {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                start += String.valueOf(board[i][j]);
            }
        }

        int[][] dir = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        Set<String> visited = new HashSet<>();
        visited.add(start);
        int step = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j = 0; j < size; j++) {
                String cur = q.poll();
                if(cur.equals(target)) {
                    return step;
                }
                int index = cur.indexOf('0');
                int[] curDir = dir[index];
                for(int i = 0; i < curDir.length; i++) {
                    String nei = swap(cur, index, curDir[i]);
                    if(!visited.contains(nei)) {
                        q.offer(nei);
                        visited.add(nei);
                    }
                    if(nei.equals(target)) {
                        return ++step;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String swap(String str, int i, int j) {
        char[] charArray= str.toCharArray();
        char tmp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = tmp;
        return String.valueOf(charArray);
    }
}
