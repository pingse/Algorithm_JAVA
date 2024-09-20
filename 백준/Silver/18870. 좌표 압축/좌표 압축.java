import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        int p = 0;

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[][] number1 = new int[n][2];

        for (int i = 0; i < n; i++) {
            number1[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            number1[i][1] = p;
            p++;
        }
        Arrays.sort(number1, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }));

        int[] ans = new int[n];
        p = 0;
        ans[number1[0][1]] = p;
        for (int i = 1; i < n; i++) {
            if (number1[i][0] != number1[i-1][0]) {
                p++;
            }
            ans[number1[i][1]] = p;
        }

        for (int i = 0; i < n; i++) {
            bufferedWriter.write(ans[i] + " ");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
