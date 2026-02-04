import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int n;
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];

        factorial(0, "");
        System.out.println(sb.toString());
    }

    static void factorial(int a, String s) {
        if (a == n) {
            sb.append(s).append("\n");
            return;
        }

        for (int i = 1; i<=n; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            factorial(a+1, a == 0 ? String.valueOf(i) : s + " " + i);
            visited[i] = false;
        }
    }
}
