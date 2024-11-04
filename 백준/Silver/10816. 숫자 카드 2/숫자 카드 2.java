import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();

        String str1 = br.readLine();
        st = new StringTokenizer(str1);
        int m = Integer.parseInt(br.readLine());
        String str2 = br.readLine();

        for (int i = 0; i < n; i++) {
            int key = Integer.parseInt(st.nextToken());

            if (map.get(key) == null) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key)+1);
            }
        }

        st = new StringTokenizer(str2);

        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            bw.write((map.get(key) != null ? map.get(key) : "0") + " ");
        }
        
        bw.flush();
        bw.close();

    }
}
