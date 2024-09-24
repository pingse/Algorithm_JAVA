import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int ans = 0;

        for (int i = 1; i*i <= n; i++) {
            ans++;
        }


        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
    }
}
