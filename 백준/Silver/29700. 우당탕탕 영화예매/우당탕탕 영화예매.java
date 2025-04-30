import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean state = false;
        int count = 0;
        String str;

        for (int i = 0; i < y; i++) {
            str = br.readLine();
            int chair = 0;
            for (int j = 0; j < x; j++) {
                if (str.charAt(j) == '1') {
                    chair--;
                    if (chair < k) {
                        chair = 0;
                    }
                } else {
                    chair++;
                    if (chair > k) {
                        chair--;
                    }
                }
                if (chair == k) count++;
            }
        }
        System.out.print(count);

    }
}
