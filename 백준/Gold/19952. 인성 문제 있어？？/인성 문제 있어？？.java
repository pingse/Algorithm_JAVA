import java.io.*;
import java.util.*;

public class Main {
 
    static int T, H, W, O, F, sX, sY, eX, eY, map[][];
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    static class Info {
        int x, y, p;
 
        public Info(int x, int y, int p) {
            super();
            this.x = x;
            this.y = y;
            this.p = p;
        }
        
    }
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            O = Integer.parseInt(st.nextToken());
            F = Integer.parseInt(st.nextToken());
            sX = Integer.parseInt(st.nextToken()) - 1;
            sY = Integer.parseInt(st.nextToken()) - 1;
            eX = Integer.parseInt(st.nextToken()) - 1;
            eY = Integer.parseInt(st.nextToken()) - 1;
            
            map = new int[H][W];
            
            // 장애물 정보 입력
            for (int i = 0; i < O; i++) {
                
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int l = Integer.parseInt(st.nextToken());
                
                map[x][y] = l;
            }
            
            if(isArrive()) System.out.println("잘했어!!");
            else System.out.println("인성 문제있어??");
        }
 
    }
 
    private static boolean isArrive() {
        
        boolean[][] visited = new boolean[H][W];
        Queue<Info> q = new LinkedList<>();
        
        visited[sX][sY] = true;
        q.add(new Info(sX, sY, F));
        while(!q.isEmpty()) {
            
            Info now = q.poll();

            if(now.p == 0) continue;
            
            for (int d = 0; d < 4; d++) {
                int xx = now.x + dx[d];
                int yy = now.y + dy[d];

                if(xx < 0 || xx >= H || yy < 0 || yy >= W) continue;

                if(visited[xx][yy]) continue;

                if(now.p < map[xx][yy] - map[now.x][now.y]) continue;
                
                if(xx == eX && yy == eY) return true;
                
                visited[xx][yy] = true;
                q.add(new Info(xx, yy, now.p - 1));
            }
            
        }
        
        return false;
    }
 
}