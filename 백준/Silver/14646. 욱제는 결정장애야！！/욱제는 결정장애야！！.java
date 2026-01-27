import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int max = 0;
        int temp = 0;
        boolean[] sticker = new boolean[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i<n*2; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (sticker[x]) {
                temp--;
            } else {
                sticker[x] = true;
                temp++;
            }
            max = Math.max(max, temp);
        }

        System.out.println(max);
    }
}
