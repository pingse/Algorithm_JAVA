import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        long ans = 0;
        long cnt = 0;
        long base = 0;

        for (char c : s.toCharArray()) {

            if (c == '1') {
                cnt++;
                base++;
            } else {
                ans += cnt * (cnt - 1) / 2;
                cnt = 0;
            }

        }

        ans += cnt * (cnt - 1) / 2;

        System.out.println(ans + base);
    }
}
