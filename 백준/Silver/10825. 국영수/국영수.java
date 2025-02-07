import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Map<String, int[]> map = new HashMap<>();
        List<String> arr = new ArrayList<>();

        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            arr.add(st.nextToken());
            map.put(arr.get(i), new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(arr, (o1, o2) -> {
            if (map.get(o1)[0] == map.get(o2)[0]) {
                if (map.get(o1)[1] == map.get(o2)[1]) {
                    if (map.get(o1)[2] == map.get(o2)[2]) {
                        return o1.compareTo(o2);
                    } else {
                        return map.get(o2)[2] - map.get(o1)[2];
                    }
                } else {
                    return map.get(o1)[1] - map.get(o2)[1];
                }
            } else {
                return map.get(o2)[0] - map.get(o1)[0];
            }
        } );

        for (int i = 0; i < n; i++) {
            bw.write(arr.get(i) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
