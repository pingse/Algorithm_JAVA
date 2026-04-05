import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] board;

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            board[r][c] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            map.put(X, C);
        }

        Deque<int[]> snake = new ArrayDeque<>();
        snake.add(new int[]{0, 0});
        board[0][0] = 2;

        int dir = 0;
        int time = 0;

        while(true) {
            time++;

            int[] head = snake.peekFirst();
            int ny = head[0] + dy[dir];
            int nx = head[1] + dx[dir];

            if (ny < 0 || nx < 0 || ny >= N || nx >= N || board[ny][nx] == 2) break;

            if (board[ny][nx] == 1) {
                board[ny][nx] = 2;
                snake.addFirst(new int[]{ny, nx});
            } else {
                board[ny][nx] = 2;
                snake.addFirst(new int[]{ny, nx});

                int[] tail = snake.pollLast();
                board[tail[0]][tail[1]] = 0;
            }

            if (map.containsKey(time)) {
                char c = map.get(time);
                if (c == 'D') dir = (dir + 1) % 4;
                else dir = (dir + 3) % 4;
            }
        }

        System.out.println(time);
    }
}
