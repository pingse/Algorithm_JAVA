import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;

        for (int i = 1; i<=n-3; i++) {
            for (int j = i+1; j<=n-2; j++) {
                for (int k = j+1; k<=n-1; k++) {
                    int value1 = 1;

                    for (int a = 0; a<i; a++) {
                        value1 *= arr[a];
                    }

                    int value2 = 1;

                    for (int b = i; b<j; b++) {
                        value2 *= arr[b];
                    }

                    int value3 = 1;

                    for (int c = j; c<k; c++) {
                        value3 *= arr[c];
                    }

                    int value4 = 1;

                    for (int d = k; d<n; d++) {
                        value4 *= arr[d];
                    }

                    answer = Math.max(value1+value2+value3+value4, answer);
                }
            }
        }

        System.out.println(answer);
    }
}
