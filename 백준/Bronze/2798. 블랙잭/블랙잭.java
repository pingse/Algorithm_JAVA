import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] cardNumber = new int[n];

        for (int i = 0; i < n; i++) {
            cardNumber[i] = scanner.nextInt();
        }

        int max = 0;

        for (int a = 0; a < n-2; a++) {
            for (int b = a + 1; b < n-1; b++) {
                for (int c = b + 1; c < n; c++) {
                    if (cardNumber[a] + cardNumber[b] + cardNumber[c] <= m && cardNumber[a] + cardNumber[b] + cardNumber[c] >= max) {
                        max = cardNumber[a] + cardNumber[b] + cardNumber[c];
                    }
                }
            }
        }

        System.out.println(max);
    }
}
