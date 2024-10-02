import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    public static void main(String[] args) throws IOException {
        HashSet<String> set = new HashSet<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();
            if (a.equals("ChongChong") || b.equals("ChongChong")) {
                if (a.equals("ChongChong")) {
                    set.add(b);
                    set.add("ChongChong");
                } else {
                    set.add(a);
                    set.add("ChongChong");
                }
            }else if (set.contains(a) || set.contains(b)) {
                if (set.contains(a)) {
                    set.add(b);
                } else {
                    set.add(a);
                }
            }
        }
        bw.write(Integer.toString(set.size()));
        bw.flush();
        bw.close();
    }
}
