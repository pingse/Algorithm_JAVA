import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> noEar = new HashMap<>();
        Map<String, Integer> noEye = new HashMap<>();
        Map<String, Integer> noEarEye = new TreeMap<>((o1, o2) -> o1.compareTo(o2));

        for (int i = 0; i < n; i++) {
            noEar.put(br.readLine(), i);
        }

        for (int i = 0; i < m; i++) {
            noEye.put(br.readLine(), i);
        }

        if (n > m) {
            for (String key : noEye.keySet()) {
                if (noEar.get(key) != null) {
                    noEarEye.put(key, 1);
                }
            }
        } else {
            for (String key : noEar.keySet()) {
                if (noEye.get(key) != null) {
                    noEarEye.put(key, 1);
                }
            }
        }
        bw.write(String.valueOf(noEarEye.size()) + "\n");

        for (String key : noEarEye.keySet()) {
            bw.write(key + "\n");
        }
        bw.flush();
        bw.close();
    }
}
