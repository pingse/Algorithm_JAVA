import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int total = a + b + c + d;

            switch (total) {
                case 0:
                    bw.write("D\n");
                    break;
                case 1:
                    bw.write("C\n");
                    break;
                case 2:
                    bw.write("B\n");
                    break;
                case 3:
                    bw.write("A\n");
                    break;
                case 4:
                    bw.write("E\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
