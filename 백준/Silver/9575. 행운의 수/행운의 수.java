import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        Set<Integer> nums = new HashSet<>();
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();
        Set<Integer> ab = new HashSet<>();
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            nums.clear();
            a.clear();
            b.clear();
            c.clear();
            ab.clear();

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
                    ab.add(num1+num2);
                }
            }

            for (int sum1 : ab) {
                for (int num3 : c) {
                    int sum = sum1 + num3;
                    if (isLucky(sum)) nums.add(sum);
                }
            }

            System.out.println(nums.size());
        }
    }
    static boolean isLucky(int x) {
        if (x == 0) return false;
        while (x > 0) {
            int d = x % 10;
            if (d != 5 && d != 8) return false;
            x /= 10;
        }
        return true;
    }
}
