import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] date = new int[n + 1][2];

        StringTokenizer st;
        for (int i = 1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            date[i][0] = startMonth*100 + startDay;
            date[i][1] = endMonth*100 + endDay;
        }

        Arrays.sort(date, (o1, o2) -> {
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            else return o1[0] - o2[0];
        } );

        int startMax = 301;
        int endMax = 0;
        int idx = 1;
        int answer = 0;

        while (startMax < 1201) {
            boolean state = false;

            for (int i = idx; i <= n; i++) {
                if (startMax < date[i][0]) break;

                if (date[i][1] > endMax) {
                    endMax = date[i][1];
                    idx = i+1;
                    state = true;
                }
            }

            if (state) {
                startMax = endMax;
                answer++;
            } else break;
        }

        if (endMax < 1201) {
            System.out.print(0);
        } else {
            System.out.print(answer);
        }

    }
}
