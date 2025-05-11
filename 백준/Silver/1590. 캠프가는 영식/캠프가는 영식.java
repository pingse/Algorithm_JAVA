import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        List<Long> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            long S = Long.parseLong(st.nextToken());
            long I = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            for (int j = 0; j < C; j++) {
                list.add(S + I * j);
            }
        }

        Collections.sort(list);
        long ans = 0;
        if (list.get(0) >= t) ans = list.get(0) - t;
        else if (list.get(list.size() - 1) < t) ans = -1;
        else {
            long l = 0;
            long r = list.size() - 1;
            long mid = (l + r) / 2;

            while (l < r) {
                mid = (l + r) / 2;

                if (list.get((int)mid)> t) {
                    r = mid;
                } else if (list.get((int) mid) < t) {
                    l = mid + 1;
                } else {
                    System.out.print(0);
                    return;
                }
            }
            ans = list.get((int) r) - t;
        }
        System.out.print(ans);


    }
}
