import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String[] arr;
    static boolean[] visited;
    static long max = 0;
    static long min = Long.MAX_VALUE;
    static String maxString = "";
    static String minString = "";
    static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = br.readLine().split(" ");

        for (int i = 0; i<10; i++) {
            visited = new boolean[10];
            visited[i] = true;
            backtracking(String.valueOf(i), 0, i);
        }

        System.out.println(maxString);
        System.out.println(minString);
    }

    static void backtracking(String str, int count, int prev) {
        if (count == n) {
            long value = Long.parseLong(str);
            if (max < value) {
                max = value;
                maxString = str;
            }

            if (min > value) {
                min = value;
                minString = str;
            }
            return;
        }
        for (int i = 0; i<10; i++) {
            if (visited[i]) continue;

            if (arr[count].equals(">") && prev > i || arr[count].equals("<") && prev < i) {
                visited[i] = true;
                backtracking(str + String.valueOf(i), count + 1, i);
                visited[i] = false;
            }
        }
    }
}
