import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int count1 = 0;
                int count2 = 0;

                for (int i = 0; i < o1.length(); i++) {
                    if (o1.charAt(i) - '0' <= 9) {
                        count1 += (int) (o1.charAt(i) - '0');
                    }
                    if (o2.charAt(i) - '0' <= 9) {
                        count2 += (int) (o2.charAt(i) - '0');
                    }
                }

                if (count1 != count2) {
                    return count1 - count2;
                } else {
                    return o1.compareTo(o2);
                }
            }
        } );

        for (int i = 0; i < n; i++) {
            bw.write(arr[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
