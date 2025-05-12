import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i<=n; i++) {
            list.add(new ArrayList<>());
            if (i == 0) continue;
            
            for (int j = 1; j<=n; j++) {
                if (i == j) continue;
                if (computers[i-1][j-1] == 1) list.get(i).add(j);
            }
        }
        
        for (int i = 1; i<=n; i++) {
            if (visited[i-1]) continue;
            answer++;
            dfs(i);
        }
        
        return answer;
    }
    
    static void dfs(int start) {
        
        visited[start-1] = true;
        
        for (int next : list.get(start)) {
            if (visited[next-1]) continue;
            
            dfs(next);
        }
    }
}