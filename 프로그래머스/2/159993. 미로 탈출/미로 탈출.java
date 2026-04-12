import java.util.*;

class Solution {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[] s;
    static int[] l;
    static int[] e;
    static int answer = 0;
    static boolean canLeave = false;
    public int solution(String[] maps) {
        for (int i = 0; i<maps.length; i++) {
            for (int j = 0; j<maps[0].length(); j++) {
                if (maps[i].charAt(j) == 'S') {
                    s = new int[]{i, j};
                } else if (maps[i].charAt(j) == 'L') {
                    l = new int[]{i, j};
                } else if (maps[i].charAt(j) == 'E') {
                    e = new int[]{i, j};
                }
            }
        }
        bfs(maps, s, l);
        if (!canLeave) return -1;
        
        bfs(maps, l, e);
        
        if (canLeave) return answer;
        else return -1;
    }
    
    static void bfs(String[] maps, int[] start, int[] end) {
        int y = maps.length;
        int x = maps[0].length();
        
        boolean[][] visited = new boolean[y][x];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            if (end[0] == cur[0] && end[1] == cur[1]) {
                answer += cur[2];
                canLeave = true;
                return;
            }
            
            for (int i = 0; i<4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];
                
                if (ny < 0 || nx < 0 || ny >= y || nx >= x) continue;
                if (maps[ny].charAt(nx) == 'X') continue;
                if (visited[ny][nx]) continue;
                
                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx, cur[2]+1});
            }
        }
        
        canLeave = false;
    }
}