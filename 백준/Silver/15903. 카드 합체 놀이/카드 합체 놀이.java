import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        long answer = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        for (int i = 0; i < m; i++) {
            Arrays.sort(arr);
            
            long sum = arr[0] + arr[1];
            arr[0] = sum;
            arr[1] = sum;
        }

        for (int i = 0; i < n; i++) {
            answer += arr[i];
        }
        System.out.print(answer);
    }
}
