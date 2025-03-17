import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[] isPrime = new boolean[1004002];

    public static void main(String[] args) throws IOException {
        setPrime();

        int n = Integer.parseInt(br.readLine());

        while (n < isPrime.length) {
            if (!isPrime[n] && palindrome(n)) {
                System.out.print(n);
                break;
            }
            n++;
        }
    }

    static void setPrime() {
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i]) {
                continue;
            }

            for (int j = i * 2; j < isPrime.length; j += i) {
                isPrime[j] = true;
            }
        }
    }
    static boolean palindrome(int n) {
        String str = Integer.toString(n);
        boolean state = true;

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                state = false;
            }
        }

        return state;
    }
}
