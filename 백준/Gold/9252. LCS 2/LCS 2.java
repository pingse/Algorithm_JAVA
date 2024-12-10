import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static String[] first;
    static String[] second;
    static int[][] dp;
    static String[] text;
    static int next;
    public static void main(String[] args) throws IOException {
        first = br.readLine().split("");
        second = br.readLine().split("");

        dp = new int[first.length+1][second.length+1];

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if (first[i - 1].equals(second[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        bw.write(Integer.toString(dp[first.length][second.length]) + "\n");

        text = new String[dp[first.length][second.length]];
        next = text.length-1;
        getText(first.length, second.length);
        for (int i = 0; i < text.length; i++) {
            bw.write(text[i]);
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void getText(int firstLength, int secondLength) {
        if (firstLength == 0 || secondLength == 0) {
            return;
        }

        if (first[firstLength - 1].equals(second[secondLength - 1])) {
            text[next] = first[firstLength - 1];
            next--;
            getText(firstLength - 1, secondLength - 1);
        } else {
            if (dp[firstLength][secondLength - 1] > dp[firstLength - 1][secondLength]) {
                getText(firstLength, secondLength - 1);
            } else {
                getText(firstLength-1, secondLength);
            }
        }
    }
}
