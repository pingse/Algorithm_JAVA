import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] H = new int[n];
        for (int i = 0; i<n; i++) {
            H[i] = Integer.parseInt(st.nextToken());
            list.add(i);
        }

        st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[n];
        for (int i = 0; i<n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Collections.sort(list, (o1, o2) -> A[o1] - A[o2]);
        long answer = 0;
        for (int i = 0; i<n; i++) {
            answer += (H[list.get(i)] + (long) A[list.get(i)] * i);
        }
        System.out.println(answer);
    }
}
