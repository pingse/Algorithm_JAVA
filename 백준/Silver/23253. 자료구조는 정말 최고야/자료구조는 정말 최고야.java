import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i<M; i++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " " );

            int temp = Integer.parseInt(st.nextToken());

            for (int j = 1; j<k; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (temp < n) {
                    System.out.println("No");
                    return;
                }

                temp = n;
            }
        }
        System.out.println("Yes");
    }
}
