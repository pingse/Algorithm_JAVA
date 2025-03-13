import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        if (n < 10) {
            System.out.print(n);
        } else {
            for (int i = 0; i < 10; i++) {
                dp(i, 1);
            }
            Collections.sort(list);
            if (n >= list.size()) {
                System.out.print("-1");
            } else {
                System.out.print(list.get(n));
            }
        }
    }

    static void dp(long num, int idx) {
        if (idx > 10) return;
        list.add(num);
        for (int i = 0; i < num % 10; i++) {
            dp((num*10) + i, idx+1);
        }
    }
}
