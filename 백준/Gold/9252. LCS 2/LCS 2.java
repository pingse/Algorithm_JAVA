import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String[] first;
    static String[] second;
    static int[][] DP;
    static String[] text;
    static int next;
    public static void main(String[] args) throws IOException {
        first = br.readLine().split("");
        second = br.readLine().split("");

        DP = new int[first.length+1][second.length+1];

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if (first[i - 1].equals(second[j - 1])) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i][j - 1], DP[i - 1][j]);
                }
            }
        }
        bw.write(Integer.toString(DP[first.length][second.length]) + "\n");

        text = new String[DP[first.length][second.length]];
        next = text.length-1;

        getText(first.length, second.length);
        for (int i = 0; i < text.length; i++) {
            bw.write(text[i]);
        }
        bw.flush();
        bw.close();

    }

    static void getText(int a, int b) {
        if (a == 0 || b == 0) {
            return;
        }

        if (first[a-1].equals(second[b-1])) {
            text[next] = first[a-1];
            next--;
            getText(a - 1, b - 1);
        } else {
            if (DP[a][b - 1] > DP[a - 1][b]) {
                getText(a, b - 1);
            } else {
                getText(a - 1, b);
            }
        }
    }



}
