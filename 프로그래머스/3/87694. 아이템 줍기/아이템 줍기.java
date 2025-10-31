import java.util.*;

class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new int[101][101];
        visited = new boolean[101][101];
        
        for (int[] r : rectangle) {
            draw(r[0]*2, r[1]*2, r[2]*2, r[3]*2);
        }
        
        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2) / 2;
        
        return answer;
    }
    
    static void draw(int startX, int startY, int endX, int endY) {
        for (int i = startY; i<=endY; i++) {
            for (int j = startX; j<=endX; j++) {
                if (map[i][j] == 2) continue;
                map[i][j] = 2;
                if (i == startY || i == endY || j == startX || j == endX) map[i][j] = 1;
            }
        }
    }
    
    static int bfs(int startX, int startY, int endX, int endY) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startY, startX, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            visited[cur[0]][cur[1]] = true;
            if (cur[0] == endY && cur[1] == endX) {
                return cur[2];
            }
            
            for (int i = 0; i<4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if (ny > 100 || nx > 100 || ny < 0 || nx < 0) continue;
                
                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    q.add(new int[]{ny, nx, cur[2]+1});
                }
            }
        }
        
        return 0;
    }
}