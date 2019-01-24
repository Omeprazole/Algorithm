public class L207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }

        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {
            int pre  = prerequisites[i][0];
            int ready = prerequisites[i][1];
            matrix[pre][ready] = 1;
            indegree[ready] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            count++;
            for(int i = 0; i < numCourses; i++) {
                if(matrix[cur][i] == 1) {
                    indegree[i]--;
                    if(indegree[i] == 0) {
                        q.offer(i);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
