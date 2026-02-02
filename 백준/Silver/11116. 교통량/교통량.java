import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringTokenizer st2;
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());

            int answer = 0;

            left.clear();
            right.clear();

            st = new StringTokenizer(br.readLine(), " ");
            st2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j<t; j++) {
                left.add(Integer.parseInt(st.nextToken()));
                right.add(Integer.parseInt(st2.nextToken()));
            }

            for (int j = 0; j<t; j++) {
                int l1 = left.get(j);

                int l2 = l1 + 500;

                int r1 = l2 + 500;

                int r2 = r1 + 500;

                if (left.contains(l2) && right.contains(r1) && right.contains(r2)) answer++;
            }

            System.out.println(answer);
        }
    }
}
