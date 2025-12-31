import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        String name = br.readLine();
        String her = br.readLine();

        int[] count = new int[name.length()*2];
        for (int i = 0; i<name.length(); i++) {
            count[2*i] = alphabet[name.charAt(i) - 'A'];
            count[2*i+1] = alphabet[her.charAt(i) - 'A'];
        }

        int len = 2 * name.length();

        while(len > 2) {
            for (int i = 0; i<len-1; i++) {
                count[i] += count[i+1];
                count[i] %= 10;
            }
            len--;
        }

        System.out.printf("%d%d\n", count[0], count[1]);
    }
}
