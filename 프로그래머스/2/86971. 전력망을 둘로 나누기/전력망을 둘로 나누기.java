import java.util.*;

class Solution {
    static boolean[] visited;
    static boolean[][] edges; 
    static int N;
    public int solution(int n, int[][] wires) {
        int answer = n;
        N = n+1;
        edges = new boolean[N][N];
        visited = new boolean[N];
        
        for (int[] wire : wires) {
            edges[wire[0]][wire[1]] = edges[wire[1]][wire[0]] = true;
        }
        
        for (int[] wire : wires) {
            Arrays.fill(visited, false);
            visited[wire[1]] = true;
            answer = Math.min(answer, Math.abs(n - dfs(wire[0], 0)*2));
        }
        return answer;
    }
    
    static int dfs(int cur, int count) {
        if (visited[cur]) {
            return 0;
        }
        visited[cur] = true;
        int sum = 1;
        for (int i = 0; i<N; i++) {
            if (edges[cur][i]) {
                sum += dfs(i, count+1);
            }
        }
        
        visited[cur] = false;
        return sum;
    }
}