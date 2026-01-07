import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int temp = 0;
        int ans = 0;
        
        if (N == 0) {
            System.out.println(0);
            return;
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<N; i++) {
            int now = Integer.parseInt(st.nextToken());

            if (temp + now <= M) {
                temp+= now;
            } else {
                ans++;
                temp = 0;
                temp += now;
            }
        }
        if (temp > 0) ans++;

        System.out.println(ans);
    }
}
