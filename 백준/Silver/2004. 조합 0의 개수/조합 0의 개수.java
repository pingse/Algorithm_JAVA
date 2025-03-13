import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int five = findFive(n) - findFive(n - r) - findFive(r);
        int two = findTwo(n) - findTwo(n - r) - findTwo(r);

        System.out.print(Math.min(five, two));
    }

    static int findFive(int n) {
        int count = 0;
        while (n != 0) {
            count += n/5;
            n /= 5;
        }
        return count;
    }

    static int findTwo(int n) {
        int count = 0;
        while (n != 0) {
            count += n/2;
            n /=2;
        }
        return count;
    }
}
