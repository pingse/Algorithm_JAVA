import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int count = 0;
        int answer = 0;

        for (int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = n-1; i>=0; i--) {
            count++;
            if (count == 3) {
                count = 0;
            } else {
                answer += arr[i];
            }
        }

        System.out.println(answer);
    }
}
