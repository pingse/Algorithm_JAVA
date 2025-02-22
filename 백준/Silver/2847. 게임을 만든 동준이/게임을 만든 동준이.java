import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[n - 1];
        int answer = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= max) {
                answer += arr[i] - (max - 1);
                max -= 1;
            } else {
                max = arr[i];
            }
        }

        System.out.print(answer);
    }
}
