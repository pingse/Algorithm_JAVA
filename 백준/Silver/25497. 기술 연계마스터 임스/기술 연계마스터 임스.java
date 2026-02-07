import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int s = 0;
        int l = 0;
        int ans = 0;
        for (int i = 0; i<n; i++) {
            char c = str.charAt(i);
            if (c - '0' >= 1 && c - '0' <= 9) {
                ans++;
            } else if (c == 'K') {
                if (s > 0) {
                    s--;
                    ans++;
                } else {
                    break;
                }
            } else if (c == 'R') {
                if (l > 0) {
                    l--;
                    ans++;
                } else {
                    break;
                }
            } else {
                if (c == 'S') {
                    s++;
                } if (c == 'L') {
                    l++;
                }
            }
        }
        System.out.println(ans);
    }
}
