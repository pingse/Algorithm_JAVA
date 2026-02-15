import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()) % 100;

        int[] targets = {5, 10, 15, 20};

        if (n == 0) {
            System.out.println("0");
            return;
        }

        for (int c : targets) {

            if (n <= c) {
                System.out.println((n - 1) / 5 + 1);
                return;
            }
            n -= c;

            if (n <= c) {
                int pos = c - n;
                if (pos == 0) {
                    System.out.println(0);
                } else {
                    System.out.println((pos - 1) / 5 + 1);
                }
                return;
            }
            n -= c;
        }

    }
}
