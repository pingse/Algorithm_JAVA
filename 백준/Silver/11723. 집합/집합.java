import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Set<Integer> set = new HashSet<>();
        Integer[] allNum = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = 0;
            String str = st.nextToken();
            if (!str.equals("empty") && !str.equals("all")) {
                num = Integer.parseInt(st.nextToken());
            }

            switch(str) {
                case "add":
                    set.add(num);
                    break;
                case "remove":
                    set.remove(num);
                    break;
                case "check":
                    bw.write(set.contains(num) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    if (set.contains(num)) {
                        set.remove(num);
                    } else {
                        set.add(num);
                    }
                    break;
                case "all":
                    set = new HashSet<>(Arrays.asList(allNum));
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
