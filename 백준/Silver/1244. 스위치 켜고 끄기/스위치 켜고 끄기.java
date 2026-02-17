import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        boolean[] buttons = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            buttons[i] = st.nextToken().equals("1");
        }

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            boolean s = st.nextToken().equals("1");
            int number = Integer.parseInt(st.nextToken());

            if (s) {
                for (int j = number; j <= n; j += number) {
                    buttons[j - 1] = !buttons[j - 1];
                }
            } else {
                int l = number;
                int r = number;
                while (l > 0 && r <= n) {
                    if (buttons[l-1] == buttons[r-1]) {
                        if (l == r) buttons[l-1] = !buttons[l-1];
                        else {
                            buttons[l-1] = !buttons[l-1];
                            buttons[r-1] = !buttons[r-1];
                        }
                    } else break;
                    l--;
                    r++;
                }
            }
        }

        for (int i = 1; i<=n; i++) {
            if (buttons[i-1]) sb.append("1 ");
            else sb.append("0 ");

            if (i % 20 == 0) sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
