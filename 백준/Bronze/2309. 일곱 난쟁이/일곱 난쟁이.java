import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int[] nines = new int[9];
        int total = 0;
        int a = -1;
        int b = -1;

        for (int i = 0; i < 9; i++) {
            nines[i] = Integer.parseInt(br.readLine());
            total += nines[i];
        }
        total-=100;

        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (total == nines[i] + nines[j]) {
                    a = nines[i];
                    b = nines[j];
                }
            }
        }
        Arrays.sort(nines);

        for (int i = 0; i < 9; i++) {
            if (nines[i] == a || nines[i] == b) {
                continue;
            }
            bw.write(Integer.toString(nines[i]) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
