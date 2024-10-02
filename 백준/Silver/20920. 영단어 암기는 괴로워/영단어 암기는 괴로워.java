import java.io.*;
import java.util.*;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.length() >= m) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
        List<String> words = new ArrayList<>(map.keySet());

        Collections.sort(words, (o1, o2) -> {
            if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
            if (o1.length() != o2.length()) {
                return o2.length() - o1.length();
            }
            return o1.compareTo(o2);
        });
        for (String str : words) {
            bw.write(str + "\n");
        }
        bw.flush();
        bw.close();

    }
}
