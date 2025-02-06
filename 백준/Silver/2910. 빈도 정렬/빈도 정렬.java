import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer> arr = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
            list.add(arr.get(i));
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
        }

        Collections.sort(arr, (o1, o2) -> {
            if (map.get(o1) == map.get(o2)) {
                return list.indexOf(o1) - list.indexOf(o2);
            } else {
                return Integer.compare(map.get(o2), map.get(o1));
            }
        } );

        for (int i = 0; i < list.size(); i++) {
            bw.write(Integer.toString(arr.get(i)) + " ");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
