import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        String[] numbers = new String[T];
        int answer = 0;

        for (int t = 0; t<T; t++) {
            numbers[t] = br.readLine();
        }

        int len = numbers[0].length();

        for (int i = 1; i<=len; i++) {
            Set<String> set = new HashSet<>();

            for (int j = 0; j<T; j++) {
                set.add(numbers[j].substring(len-i));
            }

            if (set.size() == T) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
