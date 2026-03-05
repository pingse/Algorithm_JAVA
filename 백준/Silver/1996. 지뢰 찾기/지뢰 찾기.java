import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[][] answer = new int[n][n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<n; i++) {
            String line = br.readLine();
            for (int j = 0; j<n; j++) {
                if (line.charAt(j) != '.') {
                    answer[i][j] = -1;
                    for (int k = 0; k<8; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
                        if (answer[ny][nx] == -1) continue;

                        answer[ny][nx] += line.charAt(j) - '0';
                    }
                }
            }
        }

        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                sb.append(answer[i][j] == -1 ? "*" : (answer[i][j] > 9 ? "M" : answer[i][j]));
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
