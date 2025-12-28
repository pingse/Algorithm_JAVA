import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static char[] min;
    static boolean finished = false;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        for (int i = 1; i<=3; i++) {
            min = new char[n];
            min[0] = (char) ('0' + i);
            bt(1);
            if (finished) break;
        }
    }

    static void bt(int depth) {
        if (finished) return;

        if (depth == n) {
            System.out.println(String.valueOf(min));
            finished = true;
            return;
        }

        for (int i = 1; i<=3; i++) {
            min[depth] = (char) ('0'+i);

            if (checkString(depth+1)) {
                bt(depth+1);
            }
        }
    }

    static boolean checkString(int n) {
        for (int i = 1; i<=n/2; i++) {
            boolean isSame = true;
            for (int k = 0; k<i; k++) {
                if (min[n-i-k-1] != min[n-k-1]) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) return false;
        }

        return true;
    }

}
