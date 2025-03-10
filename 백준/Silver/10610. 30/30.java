import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String str = br.readLine();

        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;

        while (i != str.length()) {
            int n = str.charAt(i) - '0';
            list.add(n % 10);
            i++;
        }

        if (!list.contains(0)) {
            System.out.print("-1");
        } else {
            int sum = 0;
            for (int a : list) {
                sum += a;
            }

            if (sum % 3 == 0) {
                Collections.sort(list, Collections.reverseOrder());
                for (int a : list) {
                    System.out.print(a);
                }
            } else {
                System.out.print("-1");
            }
        }
    }
}
