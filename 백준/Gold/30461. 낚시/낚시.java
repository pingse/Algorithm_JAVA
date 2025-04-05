import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static int y;
    static int x;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        arr = new int[y + 1][x + 1];

        for (int i = 1; i <= y; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= x; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr[i][j] += arr[i - 1][j];
            }
        }

        for (int i = 1; i <= x; i++) {
            dp(1, i);
        }

        for (int i = 2; i <= y; i++) {
            dp(i, 1);
        }


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int Y = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            bw.write(arr[Y][X] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static void dp(int ny, int nx) {
        while (true) {
            ny+=1;
            nx+=1;
            if (ny > y || nx > x) {
                break;
            }
            arr[ny][nx] += arr[ny - 1][nx - 1];
        }
    }
}
