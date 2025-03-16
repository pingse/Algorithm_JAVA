import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] isPrime;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        isPrime = new boolean[10001];
        setPrime();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            Map<Integer, Integer> map = new HashMap<>();
            map.put(start, 0);
            queue.add(start);
            boolean state = false;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                int next = map.get(cur);

                if (cur == end) {
                    state = true;
                    break;
                }
                int[] temp = {cur/1000, (cur/100)%10, (cur/10)%10, cur%10};
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 10; k++) {
                        if (j == 0 && k == 0) {
                            continue;
                        }

                        int t = temp[j];
                        temp[j] = k;
                        int change = temp[0] * 1000 + temp[1] * 100 + temp[2] * 10 + temp[3];
                        temp[j] = t;

                        if (isPrime[change]) {
                            continue;
                        }

                        if (!map.containsKey(change)) {
                            map.put(change, next + 1);
                            queue.add(change);
                        }
                    }
                }
            }
            if (!state) {
                bw.write("Impossible\n");
            } else {
                bw.write(map.get(end) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void setPrime() {
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                continue;
            }

            for (int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
    }
}
