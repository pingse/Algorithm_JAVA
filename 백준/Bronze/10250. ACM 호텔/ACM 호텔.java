import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int answerY = m % h == 0 ? h : m%h;
            int answerX = m % h == 0 ? m/h : m/h+1;

            bw.write(Integer.toString(answerY) + (answerX < 10 ? "0" : "")+Integer.toString(answerX) +"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
