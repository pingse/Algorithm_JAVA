class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        int[][] graph = new int[n+1][n+1];
        
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1;
            graph[result[1]][result[0]] = -1;
        }
        
        for (int i = 1; i<=n; i++) {
            for (int j = 1; j<=n; j++) {
                for (int k = 1; k<=n; k++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    } else if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        
        for (int i = 1; i<=n; i++) {
            int c = 0;
            for (int j = 1; j<=n; j++) {
                if (i == j) continue;
                
                if (graph[i][j] != 0) c++;
            }
            if (c == n-1) answer++;
        }
        return answer;
    }
}