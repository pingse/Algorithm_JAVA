import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static int[][] board;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        board = new int[n+1][m+1];
        int min = Integer.MAX_VALUE;
        boolean isBlack = true;

        Arrays.fill(board[0], 0);
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            board[i][0] = 0;
            for (int j = 1; j <= m; j++) {
                char c = str.charAt(j - 1);
                if ((!isBlack && c == 'B') || (isBlack && c == 'W')) {
                    board[i][j] = board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1] + 1;
                } else {
                    board[i][j] = board[i - 1][j] + board[i][j - 1] - board[i - 1][j - 1];
                }
                isBlack = !isBlack;
            }
            isBlack = i % 2 != 1;
        }

        for (int i = k; i <= n; i++) {
            for (int j = k; j <= m; j++) {
                min = Math.min(min, Math.min((board[i][j]-board[i-k][j]-board[i][j-k]+board[i-k][j-k]),
                        Math.abs((int) (Math.pow(k, 2) - (board[i][j]-board[i-k][j]-board[i][j-k]+board[i-k][j-k])))));
            }
        }

        bw.write(Integer.toString(min));
        bw.flush();
        bw.close();
    }
}
