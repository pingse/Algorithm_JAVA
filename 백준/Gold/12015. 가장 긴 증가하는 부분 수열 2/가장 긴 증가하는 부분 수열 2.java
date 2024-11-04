import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static int[] arr;
    static int[] LIS;
    static int LISLength;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        LIS = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        LIS[0] = arr[0];
        LISLength = 1;

        for (int i = 1; i < n; i++) {
            int current = arr[i];

            if (LIS[LISLength - 1] < current) {
                LISLength++;
                LIS[LISLength - 1] = current;
            } else {
                int start = 0;
                int end = LISLength;

                while (start < end) {
                    int half = (start + end) / 2;

                    if (LIS[half] < current) {
                        start = half + 1;
                    } else {
                        end = half;
                    }
                }

                LIS[start] = current;
            }
        }

        bw.write(Integer.toString(LISLength));
        bw.flush();
        bw.close();

    }

}
