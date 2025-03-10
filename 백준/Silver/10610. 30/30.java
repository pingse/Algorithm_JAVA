import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            int n = arr[i] - '0';
            sum += n;
            sb.append(n);
        }

        if (arr[0] - '0' != 0 || sum % 3 != 0) {
            System.out.print("-1");
        } else {
            System.out.print(sb.toString());
        }
    }
}
