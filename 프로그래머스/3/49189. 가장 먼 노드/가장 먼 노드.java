import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> graph = new ArrayList<>();
        int[] count = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        for (int i = 0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] path : edge) {
            graph.get(path[0]).add(path[1]);
            graph.get(path[1]).add(path[0]);
        }
        
        int max = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            count[cur[0]] = cur[1];
            max = Math.max(count[cur[0]], max);
            
            for (int next : graph.get(cur[0])) {
                if (visited[next]) continue;
                
                visited[next] = true;
                queue.add(new int[]{next, cur[1] + 1});
            }
        }
        
        for (int i = 1; i<=n; i++) {
            if (max == count[i]) answer++;
        }
        return answer;
    }
}