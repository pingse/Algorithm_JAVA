import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        int center = N / 2;
        map[center][center] = 1;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int r = center, c = center;
        int num = 2;
        int step = 1;
        int dir = 0;

        int ansR = center + 1;
        int ansC = center + 1;

        if (target == 1) {
            ansR = center + 1;
            ansC = center + 1;
        }

        while (num <= N * N) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < step; j++) {

                    if (num > N * N) break;

                    r += dr[dir];
                    c += dc[dir];

                    map[r][c] = num;

                    if (num == target) {
                        ansR = r + 1;
                        ansC = c + 1;
                    }

                    num++;
                }
                dir = (dir + 1) % 4;
            }
            step++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(ansR).append(" ").append(ansC);

        System.out.print(sb);
    }
}
