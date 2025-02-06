import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        String str = "";
        String temp = "";

        while (n > 0) {
            while (st.hasMoreTokens()) {
                str = st.nextToken();
                temp = "";
                for (int i = str.length() - 1; i >= 0; i--) {
                    temp += str.charAt(i);
                }
                arr[--n] = Long.parseLong(temp);
            }
            if (n > 0) {
                st = new StringTokenizer(br.readLine(), " ");
            }

        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            bw.write(Long.toString(arr[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
