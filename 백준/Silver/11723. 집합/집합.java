import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int k = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = 0;
            String str = st.nextToken();
            if (!str.equals("empty") && !str.equals("all")) {
                num = Integer.parseInt(st.nextToken());
            }

            switch(str) {
                case "add":
                    k |= (1 << num);
                    break;
                case "remove":
                    k &= ~(1 << num);
                    break;
                case "check":
                    bw.write((k & (1<<num)) == (1<<num) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    k ^= (1 << num);
                    break;
                case "all":
                    k = (1<<21) -1;
                    break;
                case "empty":
                    k = 0;
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
