import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char[][] map = new char[y][x];
        int time = 0;
        Queue<int[]> water = new ArrayDeque<>();
        Queue<int[]> hedgehog = new ArrayDeque<>();
        for (int i = 0; i<y; i++) {
            String str = br.readLine();

            for (int j = 0; j<x; j++) {
                map[i][j] = str.charAt(j);
                if(map[i][j]=='*') water.add(new int[]{i,j});
                if(map[i][j]=='S') hedgehog.add(new int[]{i,j});
            }
        }

        while(!hedgehog.isEmpty()) {

            int wsize = water.size();
            for(int i=0;i<wsize;i++){
                int[] cur = water.poll();

                for(int d=0; d<4; d++){
                    int ny = cur[0] + dy[d];
                    int nx = cur[1] + dx[d];

                    if(ny<0||nx<0||ny>=y||nx>=x) continue;
                    if(map[ny][nx] != '.') continue;

                    map[ny][nx] = '*';
                    water.add(new int[]{ny,nx});
                }
            }

            int hsize = hedgehog.size();
            for(int i=0;i<hsize;i++){

                int[] cur = hedgehog.poll();

                for(int d=0; d<4; d++){
                    int ny = cur[0] + dy[d];
                    int nx = cur[1] + dx[d];

                    if(ny<0||nx<0||ny>=y||nx>=x) continue;

                    if(map[ny][nx]=='D'){
                        System.out.println(time+1);
                        return;
                    }

                    if(map[ny][nx] != '.') continue;

                    map[ny][nx] = 'S';
                    hedgehog.add(new int[]{ny,nx});
                }
            }

            time++;
        }

        System.out.println("KAKTUS");
    }
}
