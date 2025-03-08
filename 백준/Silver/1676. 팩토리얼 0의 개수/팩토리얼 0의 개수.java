import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        while (n >= 5) {
            count += n / 5;
            n /= 5;
        }
        System.out.print(count);
    }
}
