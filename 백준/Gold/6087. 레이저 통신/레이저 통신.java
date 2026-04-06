import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static class Node {
        int y, x, dir;

        public Node(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char[][] map = new char[H][W];
        List<int[]> C = new ArrayList<>();

        for (int i = 0; i<H; i++) {
            String str = br.readLine();
            for (int j = 0; j<W; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'C') C.add(new int[]{i, j});
            }
        }

        int sy = C.get(0)[0];
        int sx = C.get(0)[1];
        int ey = C.get(1)[0];
        int ex = C.get(1)[1];

        Deque<Node> dq = new ArrayDeque<>();
        int INF = Integer.MAX_VALUE;

        int[][][] dist = new int[H][W][4];

        for (int i = 0; i<H; i++) {
            for (int j = 0; j<W; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        for (int i = 0; i<4; i++) {
            dist[sy][sx][i] = 0;
            dq.add(new Node(sy, sx, i));
        }

        while(!dq.isEmpty()) {
            Node cur = dq.poll();

            for (int i = 0; i<4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny >= H || nx >= W || ny < 0 || nx < 0) continue;
                if (map[ny][nx] == '*') continue;

                int cost = dist[cur.y][cur.x][cur.dir];

                if (cur.dir != i) cost += 1;
                if (dist[ny][nx][i] > cost) {
                    dist[ny][nx][i] = cost;

                    if (cur.dir == i) dq.addFirst(new Node(ny, nx, i));
                    else dq.addLast(new Node(ny, nx, i));
                }
            }
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i<4; i++) {
            answer = Math.min(answer, dist[ey][ex][i]);
        }

        System.out.println(answer);

    }
}
