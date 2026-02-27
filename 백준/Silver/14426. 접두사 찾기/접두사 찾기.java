import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int answer = 0;

        String[] strings = new String[N];
        for (int i = 0; i<N; i++) {
            strings[i] = br.readLine();
        }

        Arrays.sort(strings);

        for (int i = 0; i<M; i++) {
            String prefix = br.readLine();

            int idx = Arrays.binarySearch(strings, prefix);

            if (idx < 0) {
                idx = -idx - 1;
            }

            if (idx < N && strings[idx].startsWith(prefix)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
