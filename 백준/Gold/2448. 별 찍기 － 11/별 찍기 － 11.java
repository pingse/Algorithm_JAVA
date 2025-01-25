import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][] map;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        map = new char[n][2*n-1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], ' ');
        }
        star(0, n-1, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                bw.write(Character.toString(map[i][j]));
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void star(int y, int x, int size) {
        if (size == 3) {
            map[y][x] = '*';
            map[y + 1][x - 1] = map[y+1][x + 1] = '*';
            map[y + 2][x - 2] = map[y + 2][x - 1] = map[y + 2][x] = map[y + 2][x + 1] = map[y + 2][x + 2] = '*';
        } else {
            size /=2;
            star(y, x, size);
            star(y + size, x - size, size);
            star(y + size, x + size, size);
        }
    }
}
