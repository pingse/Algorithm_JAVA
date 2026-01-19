import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer = 0;
        List<Integer> score = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list.clear();

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<p; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list, Collections.reverseOrder());
            if (p >= l) {
                score.add(list.get(l-1));
            } else {
                score.add(1);
            }
        }
        Collections.sort(score);

        for (int i = 0; i<n; i++) {
            if (m - score.get(i) >= 0) {
                m -= score.get(i);
                answer++;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }
}
