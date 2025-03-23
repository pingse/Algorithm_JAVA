import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int ans = 0;
        int min = Integer.MAX_VALUE;
        while (n-- > 0) {
            int cur = Integer.parseInt(st.nextToken());
            ans = Math.max(cur - min, ans);
            min = Math.min(min, cur);
        }
        System.out.print(ans);
    }
}