import java.io.*;
import java.util.Arrays;
import java.util.Map;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    public static void main(String[] args) throws IOException {
        while (true) {
            String str = br.readLine();
            if (str == null || str.isBlank()) {
                break;
            }
            String[] strings = new String[(int) Math.pow(3, Integer.parseInt(str))];
            Arrays.fill(strings, "-");
            kan(strings, 0, strings.length-1);
            for (int i = 0; i < strings.length; i++) {
                bw.write(strings[i]);
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static void kan(String[] strings, int l, int r) {
        if (strings.length == 1) {
            return;
        } else {
            int l1 = l;
            int l2 = r- (r-l)/3;
            int r1 = l+(r-l)/3;
            int r2 = r;

            Arrays.fill(strings, r1+1, l2, " ");
            if (l1 != r1) {
                kan(strings, l1, r1);
                kan(strings, l2, r2);
            }
        }
    }

}
