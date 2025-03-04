import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] numA = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            numA[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] numB = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++) {
            numB[i] = Integer.parseInt(st.nextToken());
        }

        int sizeA = n * (n + 1) / 2;
        int sizeB = m * (m + 1) / 2;
        long[] sumA = new long[sizeA];
        long[] sumB = new long[sizeB];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            int a = 0;
            for (int j = i; j < n; j++) {
                a += numA[j];
                sumA[idx++] = a;
            }
        }
        idx = 0;
        for (int i = 0; i < m; i++) {
            int b = 0;
            for (int j = i; j < m; j++) {
                b += numB[j];
                sumB[idx++] = b;
            }
        }

        Arrays.sort(sumA);
        Arrays.sort(sumB);

        int start = 0;
        int end = sizeB -1;
        long count = 0;

        while (start < sizeA && end > -1) {
            long av = sumA[start];
            long bv = sumB[end];
            long sum = av + bv;

            if (sum == T) {
                long countA = 0;
                long countB = 0;

                while (start < sizeA && sumA[start] == av) {
                    start++;
                    countA++;
                }

                while (end > -1 && sumB[end] == bv) {
                    end--;
                    countB++;
                }
                count += countA * countB;
            }

            if (sum < T) {
                start++;
            } else if (sum > T) {
                end--;
            }
        }
        System.out.print(count);
    }
}
