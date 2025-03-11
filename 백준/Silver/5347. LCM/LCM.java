import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            int num3 = 0;
            if (num1 > num2) {
                num3 = euclidean(num1, num2);
            } else {
                num3 = euclidean(num2, num1);
            }
            long answer = (long) num1 * num2 / num3;
            bw.write(answer + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int euclidean(int a, int b) {
        int temp = 0;
        while (a != 0) {
            if (a % b == 0) {
                break;
            }
            temp = a;
            a = b;
            b = temp%b;
        }
        return b;
    }
}
