import java.util.*;

class Solution {
    
    static int[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        int answer = 0;
        
        visited = new int[maps.length][maps[0].length];
        
        answer = bfs(maps);
        
        return answer;
    }
    
    static int bfs(int[][] maps) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (cur[0] == maps.length-1 && cur[1] == maps[0].length -1 ) {
                return visited[maps.length-1][maps[0].length-1];
            }
            
            for (int i = 0; i<4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if (ny < 0 || ny >= visited.length || nx < 0 || nx >= visited[0].length) continue;
                
                if (visited[ny][nx] == 0 && maps[ny][nx] == 1) {
                    visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{ny, nx});
                }
            }
            
            
        }
        
        return -1;
    }
}