import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        long n = Long.parseLong(br.readLine());

        for (int i = 0; i < n; i++) {
            long t = Long.parseLong(br.readLine());
            while (true) {
                long count = 0;
                for (long j = 2; j <= Math.sqrt(t); j++) {
                    if (t % j == 0) {
                        count++;
                        break;
                    }
                }
                if (count != 0) {
                    t++;
                } else {
                    if (t == 0 || t == 1) {
                        bw.write("2\n");
                    } else {
                        bw.write(t + "\n");
                    }
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
