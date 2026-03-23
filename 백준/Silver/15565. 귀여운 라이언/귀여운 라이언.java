import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 1) count++;
        }
        if (count < K) {
            System.out.println(-1);
            return;
        }
        int left = 0;
        int lion = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < N; right++) {
            if (arr[right] == 1) lion++;

            while(lion >= K) {
                answer = Math.min(answer, right - left + 1);

                if (arr[left] == 1) lion--;
                left++;
            }
        }

        System.out.println(answer);
    }
}
