import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static Queue<int[]> queue = new ArrayDeque<>();
    static int time = 0;
    static int[] count = new int[6];

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        map = new int[y][x];
        visited = new boolean[y][x];

        for (int i = 0; i<y; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        int lastCheese = 0;

        while(true){

            visited = new boolean[y][x];
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{0,0});
            visited[0][0] = true;

            List<int[]> melt = new ArrayList<>();

            while(!q.isEmpty()){

                int[] cur = q.poll();

                for(int d=0; d<4; d++){

                    int ny = cur[0] + dy[d];
                    int nx = cur[1] + dx[d];

                    if(ny<0 || nx<0 || ny>=y || nx>=x) continue;
                    if(visited[ny][nx]) continue;

                    visited[ny][nx] = true;

                    if(map[ny][nx] == 0){
                        q.add(new int[]{ny,nx});
                    }else{
                        melt.add(new int[]{ny,nx});
                    }
                }
            }

            if(melt.size() == 0) break;

            lastCheese = melt.size();

            for(int[] c : melt){
                map[c[0]][c[1]] = 0;
            }

            time++;
        }

        System.out.println(time);
        System.out.println(lastCheese);
    }
}
