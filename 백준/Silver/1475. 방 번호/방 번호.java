import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int[] arr = new int[10];
        String str = br.readLine();
        int max = 0;
        int ninesix = 0;
        for (int i = 0; i < str.length(); i++) {
            arr[Integer.parseInt(Character.toString(str.charAt(i)))]++;
        }
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) {
                ninesix += arr[i];
            } else if (max < arr[i]) {
                max = arr[i];
            }
        }

        ninesix = ninesix%2 == 1 ? ninesix/2+1 : ninesix/2;
        bw.write(max < ninesix ? Integer.toString(ninesix) : Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
