import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();

        int min = Integer.MAX_VALUE;

        for (int i = 0; i<=b.length() - a.length(); i++) {
            int len = 0;
            for (int j = 0; j<a.length(); j++) {
                if (a.charAt(j) != b.charAt(i+j)) len++;
            }
            min = Math.min(min, len);
        }

        System.out.println(min);
    }
}
