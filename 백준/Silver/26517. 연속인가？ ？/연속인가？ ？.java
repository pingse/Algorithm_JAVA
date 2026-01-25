import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        long k = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long a = Long.parseLong(st.nextToken()) * k + Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken()) * k + Long.parseLong(st.nextToken());

        if (a == b) {
            System.out.println("Yes " + a);
        } else {
            System.out.println("No");
        }
    }
}
