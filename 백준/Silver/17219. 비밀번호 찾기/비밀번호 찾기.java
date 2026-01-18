import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> database = new HashMap<>();

        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            database.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i<M; i++) {
            String str = br.readLine();
            bw.write(database.get(str) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
