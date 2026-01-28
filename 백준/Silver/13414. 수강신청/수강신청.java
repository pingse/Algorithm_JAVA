import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            map.remove(s);   // 이미 있으면 제거
            map.put(s, 0);   // 다시 넣어서 순서 최신화
        }

        int cnt = 0;
        for (String s : map.keySet()) {
            if (cnt++ == n) break;
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
