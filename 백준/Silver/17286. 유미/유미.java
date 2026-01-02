import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int sx = Integer.parseInt(st.nextToken());
        int sy = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        int[][] point = new int[3][2];

        for (int i = 0; i<3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                for (int k = 0; k<3; k++) {
                    if (i == j || i == k || j == k) continue;

                    double first = Math.sqrt(Math.pow(Math.abs(sx - point[i][0]), 2) + Math.pow(Math.abs(sy - point[i][1]), 2));
                    double second = Math.sqrt(Math.pow(Math.abs(point[i][0] - point[j][0]), 2) + Math.pow(Math.abs(point[i][1] - point[j][1]), 2));
                    double third = Math.sqrt(Math.pow(Math.abs(point[j][0] - point[k][0]), 2) + Math.pow(Math.abs(point[j][1] - point[k][1]), 2));
                    min = Math.min(min, (int) Math.floor(first+second+third));
                }
            }
        }

        System.out.println(min);
    }
}
