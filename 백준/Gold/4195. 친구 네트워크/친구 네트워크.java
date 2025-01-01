import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] friend;
    static Map<String, Integer> map = new HashMap<>();
    static int[] count;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int m;

        for (int i = 0; i < n; i++) {
            m = Integer.parseInt(br.readLine());
            count = new int[m * 2 + 1];
            friend = new int[m * 2 + 1];
            for (int j = 0; j <= 2*m; j++) {
                friend[j] = j;
                count[j] = 1;
            }
            int idx = 1;
            for (int j = 1; j <= m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String f = st.nextToken();
                String l = st.nextToken();

                if (!map.containsKey(f)) {
                    map.put(f, idx++);
                }
                if (!map.containsKey(l)) {
                    map.put(l, idx++);
                }
                union(map.get(f), map.get(l));
                bw.write(union(map.get(f), map.get(l)) + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int union(int a, int b) {
        int x = find(a);
        int y = find(b);

        if (x != y) {
            friend[y] = x;
            count[x] += count[y];

            count[y] = 1;
        }

        return count[x];
    }

    static int find(int x) {
        if (x == friend[x]) {
            return x;
        } else {
            return friend[x] = find(friend[x]);
        }

    }
}
