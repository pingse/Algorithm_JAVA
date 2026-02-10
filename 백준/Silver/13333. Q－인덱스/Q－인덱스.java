import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] papers = new int[n];

        for (int i = 0; i<n; i++) {
            papers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(papers);
        int answer = 0;
        for (int i = 0; i<n; i++) {
            int k = n - i;
            if (k <= papers[i])  {
                answer = k;
                break;
            }
        }
        System.out.println(answer);
    }
}
