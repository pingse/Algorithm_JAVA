import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] offTimes = {15 * 60, 18 * 60, 21 * 60};

        long delay = 0;
        int offCnt = 0;

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= n + 1; i++) {
            for (int t : offTimes) {
                long offTime = i * 1440L + t + delay;
                offCnt++;

                if (offTime / 1440 == n) {
                    ans.add((int)(offTime % 1440));
                }

                if (offCnt % 3 == 0) delay += k;
            }
        }

        System.out.println(ans.size());

        for (int m : ans) {
            int hh = m / 60;
            int mm = m % 60;
            System.out.printf("%02d:%02d\n", hh, mm);
        }
    }
}
