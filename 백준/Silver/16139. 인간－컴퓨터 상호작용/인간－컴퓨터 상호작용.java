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
        int[][] alphabet = new int[26][words.length+1];
        StringTokenizer st;

        for (int i = 0; i < 26; i++) {
            alphabet[i][0] = 0;
            for (int j = 0; j < words.length; j++) {
                if ((int) (words[j] - 97) == i) {
                    alphabet[i][j+1] = alphabet[i][j] + 1;
                } else {
                    alphabet[i][j+1] = alphabet[i][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int word = st.nextToken().charAt(0) - 97;
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken()) + 1;

            bw.write(Integer.toString(alphabet[word][end]-alphabet[word][start]) + "\n");
        }
        bw.flush();
        bw.close();
    }
}
