import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i<n; i++) {
            int card = Integer.parseInt(st.nextToken());
            sum += card;
            max = Math.max(max, card);
        }

        sum += (max * (n-2));

        System.out.println(sum);
    }
}
