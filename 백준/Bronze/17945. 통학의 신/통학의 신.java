import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int x = (int) (-1 * A + Math.sqrt(A*A - B));
        int y = (int) (-1 * A - Math.sqrt(A*A - B));

        if (x == y) System.out.println(x);
        else System.out.println(Math.min(x, y) + " " + Math.max(x, y));
    }
}
