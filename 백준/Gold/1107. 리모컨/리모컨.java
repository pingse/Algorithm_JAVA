import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] errors = new boolean[10];
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        if (N == 100) {
            System.out.println(0);
            return;
        }
        int answer = Math.abs(N - 100);

        int M = Integer.parseInt(br.readLine());
        if (M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                errors[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for (int i = 0; i<=1000000; i++) {
            if (canPress(i)) {
                int countPress = length(i) + Math.abs(i - N);
                answer = Math.min(answer, countPress);
            }
        }

        System.out.println(answer);
    }

    static boolean canPress(int x) {
        if (x == 0) return !errors[0];

        while(x > 0) {
            if (errors[x % 10]) return false;

            x /= 10;
        }

        return true;
    }

    static int length(int x) {
        if (x == 0) return 1;
        int count = 0;
        while(x > 0) {
            count++;
            x/=10;
        }

        return count;
    }
}
