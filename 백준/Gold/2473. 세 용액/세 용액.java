import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long value = 3000000001L;
    static long[] num;
    static int[] answers = new int[3];
    static boolean isZero = false;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        num = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        for (int i = 0; i < n - 2; i++) {
            binarySearch(i);
            if (isZero) {
                break;
            }
        }
        System.out.print(num[answers[0]] + " " + num[answers[1]] + " " + num[answers[2]]);
    }

    static void binarySearch(int i) {
        int start = i+1;
        int end = num.length - 1;
        while (start < end) {
            long result = num[i] + num[start] + num[end];
            if (result == 0) {
                value = result;
                answers[0] = i;
                answers[1] = start;
                answers[2] = end;
                isZero = true;
                return;
            }

            if (Math.abs(result) < Math.abs(value)) {
                value = result;
                answers[0] = i;
                answers[1] = start;
                answers[2] = end;
            }

            if (result < 0) {
                start++;
            } else if (result > 0) {
                end--;
            }
        }
    }
}
