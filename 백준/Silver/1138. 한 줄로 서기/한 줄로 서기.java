import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<Integer> list = new ArrayList<>();

        int[] tall = new int[n];
        for (int i = 0; i<n; i++) {
            tall[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = n-1; i>=0; i--) {
            list.add(tall[i], i+1);
        }

        for (int i = 0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
