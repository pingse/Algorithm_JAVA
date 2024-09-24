import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        br.close();

        for (int i = m; i <= n; i++) {
            while (true) {
                int count = 0;

                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        count++;
                        break;
                    }
                }

                if (count == 0) {
                    if (i != 1) {
                        bw.write(i + "\n");
                    }
                }
                break;
            }
        }
        bw.flush();
        bw.close();
    }
}
