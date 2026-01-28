import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i<m; i++) {
            map.put(br.readLine(), i);
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (o1, o2) -> map.get(o1) - map.get(o2));
        int size = Math.min(n, list.size());
        for (int i = 0; i<size; i++) {
            bw.write(list.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
