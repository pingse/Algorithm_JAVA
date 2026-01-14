import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int N= Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i<T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            String test = str.substring(l-1, r);

            System.out.println(paperScore(l, r, test));
        }
    }

    static int paperScore(int l, int r, String paper) {
        int len = r - l + 1;

        int max = 0;

        for (int i = 1; i<=len/2; i++) {
            int rCount = 0;
            int lCount = 0;
            for (int j = 0; j<i; j++) {
                if (paper.charAt(len-i+j) == paper.charAt(len-i-1-j)) rCount++;
                if (paper.charAt(i-1-j) == paper.charAt(i+j)) lCount++;
            }
            max = Math.max(max, Math.max(rCount, lCount));
        }

        return max;
    }
}
