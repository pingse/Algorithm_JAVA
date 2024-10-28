import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    public static void main(String[] args) throws IOException {
        char[] words = br.readLine().toCharArray();
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            char word = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            for (int j = start; j <= end; j++) {
                if (words[j] == word) {
                    count++;
                }
            }

            bw.write(Integer.toString(count) + "\n");
            count = 0;
        }
        bw.flush();
        bw.close();
    }
}
