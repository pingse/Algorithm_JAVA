import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        long[][] map = new long[n + 1][8];
        map[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            map[i][0] = (map[i-1][1] + map[i-1][2]) % 1000000007;
            map[i][1] = (map[i-1][0] + map[i-1][2] + map[i-1][3]) % 1000000007;
            map[i][2] = (map[i-1][0] + map[i-1][1] + map[i-1][3] + map[i-1][5]) % 1000000007;
            map[i][3] = (map[i-1][1] + map[i-1][2] + map[i-1][4] + map[i-1][5]) % 1000000007;
            map[i][4] = (map[i-1][3] + map[i-1][5] + map[i-1][6]) % 1000000007;
            map[i][5] = (map[i-1][2] + map[i-1][3] + map[i-1][4] + map[i-1][7]) % 1000000007;
            map[i][6] = (map[i-1][4] + map[i-1][7]) % 1000000007;
            map[i][7] = (map[i-1][5] + map[i-1][6]) % 1000000007;
        }

        System.out.print(map[n][0]);
    }
}
