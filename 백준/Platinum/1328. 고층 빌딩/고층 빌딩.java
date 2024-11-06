import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        long[][][] building = new long[101][101][101];

        building[1][1][1] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= L; j++) {
                for (int k = 1; k <= R; k++) {
                    building[i][j][k] = (building[i - 1][j - 1][k] + building[i - 1][j][k - 1] + building[i - 1][j][k] * (i - 2)) % 1000000007;
                }
            }
        }

        bw.write(Long.toString(building[N][L][R]));
        bw.flush();
        bw.close();
    }
}
