import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] matrix;
    static int[][] dp;
    static final int INF = 987654321;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        matrix = new int[N][N];
        dp = new int[N][1 << N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(search(0, 1));
    }

    static int search(int location, int visited) {
        if (visited == ((1 << N) - 1)) {
            if (matrix[location][0] > 0) {
                return matrix[location][0];
            } else {
                return INF;
            }
        }

        if (dp[location][visited] != -1) {
            return dp[location][visited];
        }

        dp[location][visited] = INF;

        for (int i = 0; i < N; i++) {
            if (matrix[location][i] != 0 && (visited & (1 << i)) == 0) {
                dp[location][visited] = Math.min(dp[location][visited],
                        search(i, (visited | (1 << i))) + matrix[location][i]);
            }
        }

        return dp[location][visited];
    }
}
