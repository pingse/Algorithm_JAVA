import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int ans = 0;
        int number = 2;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == 1 || b == 1) {
                if (a == 1) {
                    bw.write(Integer.toString(b) + "\n");
                } else {
                    bw.write(Integer.toString(a) + "\n");
                }
            } else {
                while (number <= a || number <= b) {

                    if (a % number == 0 && b % number == 0) {
                        if (ans == 0) {
                            ans = number;
                        } else {
                            ans = ans * number;
                        }

                        a /= number;
                        b /= number;
                        number = 1;
                    }
                    number++;
                }
                if (ans == 0) {
                    bw.write(Integer.toString(a * b) + "\n");
                } else {
                    bw.write(Integer.toString(a*b*ans) + "\n");
                }
            }
            ans = 0;
            number = 2;
        }
        bw.flush();
        bw.close();
    }
}
