import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int t = 0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] row = new int[N];
            int[] col = new int[N];

            for (int i = 0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j<N; j++) {
                    int value = Integer.parseInt(st.nextToken());

                    row[i] += value;
                    col[j] += value;
                }
            }

            for (int i = 0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken())-1;
                int c1 = Integer.parseInt(st.nextToken())-1;
                int r2 = Integer.parseInt(st.nextToken())-1;
                int c2 = Integer.parseInt(st.nextToken())-1;
                int v = Integer.parseInt(st.nextToken());

                int sumRow = (r2 - r1 + 1) * v;
                int sumCol = (c2 - c1 + 1) * v;

                for (int r = r1; r<=r2; r++) {
                    row[r] += sumCol;
                }

                for (int c = c1; c<=c2; c++) {
                    col[c] += sumRow;
                }

            }

            for (int i = 0; i<N; i++) {
                bw.write(row[i] + " ");
            }
            bw.write("\n");
            for (int i = 0; i<N; i++) {
                bw.write(col[i] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
