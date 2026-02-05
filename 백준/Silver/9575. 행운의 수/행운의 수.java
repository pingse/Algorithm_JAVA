import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        Set<String> nums = new HashSet<>();
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            nums.clear();
            a.clear();
            b.clear();
            c.clear();

            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j<N; j++) {
                a.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j<M; j++) {
                b.add(Integer.parseInt(st.nextToken()));
            }

            int K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j<K; j++) {
                c.add(Integer.parseInt(st.nextToken()));
            }

            for (int num1 : a) {
                for (int num2 : b) {
                    for (int num3 : c) {
                        String str = String.valueOf((num1 + num2 + num3));
                        if (str.replace("5", "").replace("8", "").equals("")) {
                            nums.add(str);
                        }
                    }
                }
            }

            System.out.println(nums.size());
        }
    }
}
