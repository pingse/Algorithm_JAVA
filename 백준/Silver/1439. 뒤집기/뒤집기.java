import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String num = br.readLine();

        char pre = num.charAt(0);
        int count = 1;

        for (int i = 1; i < num.length(); i++) {
            char now = num.charAt(i);

            if (pre != now) {
                pre = now;
                count++;
            }
        }

        System.out.print(count / 2);

    }
}
