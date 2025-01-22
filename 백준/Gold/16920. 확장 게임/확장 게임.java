import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int y;
    static int x;
    static int P;
    static char[][] board;
    static int[] answer;
    static int[] distance;
    static Queue<int[]>[] queue;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str;
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());


        board = new char[y + 1][x + 1];
        distance = new int[P + 1];
        answer = new int[P + 1];
        queue = new LinkedList[P+1];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= P; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
            queue[i] = new LinkedList<>();
        }

        for (int i = 1; i <= y; i++) {
            str = br.readLine();
            for (int j = 1; j <= x; j++) {
                board[i][j] = str.charAt(j-1);
                if (board[i][j] != '.' && board[i][j] != '#') {
                    queue[board[i][j] - '0'].add(new int[]{i, j});
                    answer[board[i][j] - '0']++;
                }
            }
        }

        bfs();
        for (int i = 1; i <= P; i++) {
            bw.write(Integer.toString(answer[i]) + " ");
        }
        bw.flush();
        bw.close();
        br.close();

    }
    static void bfs() {
        while(true) {
            for (int i = 1; i <= P; i++) {
                for (int j = 0; j < distance[i]; j++) {
                    int size = queue[i].size();
                    for (int k = 0; k < size; k++) {
                        int[] cur = queue[i].poll();

                        for (int z = 0; z < 4; z++) {
                            int ny = cur[0] + dy[z];
                            int nx = cur[1] + dx[z];

                            if (ny > y || ny < 1 || nx > x || nx < 1) continue;

                            if (board[ny][nx] == '.') {
                                board[ny][nx] = (char) (i + '0');
                                queue[i].add(new int[]{ny, nx});
                                answer[i]++;
                            }
                        }
                    }
                    if (queue[i].isEmpty()) {
                        break;
                    }
                }
            }


            boolean state = false;
            for (int i = 1; i <= P; i++) {
                if (!queue[i].isEmpty()) {
                    state = true;
                    break;
                }
            }
            if (!state) {
                break;
            }
        }
    }
}
