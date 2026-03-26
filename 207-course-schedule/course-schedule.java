import java.util.*;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];
            
            adj.get(b).add(a);  
            indegree[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }
         int count = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            count++;
            
            for(int nei : adj.get(node)) {
                indegree[nei]--;
                
                if(indegree[nei] == 0) {
                    q.offer(nei);
                }
            }
        }
        return count == numCourses;
    }
}