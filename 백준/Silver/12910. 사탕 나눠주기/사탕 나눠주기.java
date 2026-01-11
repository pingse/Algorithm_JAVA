import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        int[] arr = new int[51];
        int[] ans = new int[51];
        ans[0] = 1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<N; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = 1; i<=50; i++) {
            ans[i] = ans[i-1] * arr[i];
        }

        for (int i = 1; i<=50; i++) {
            if (ans[i] == 0) break;
            answer += ans[i];
        }

        System.out.println(answer);
    }
}
