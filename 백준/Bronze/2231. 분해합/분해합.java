import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        int min = 0;

        for (int i = 1; i <= n; i++) {
            int a = i/1000000;
            int b = i%1000000/100000;
            int c = i%100000/10000;
            int d = i%10000/1000;
            int e = i%1000/100;
            int f = i%100/10;
            int g = i%10;

            if (i + a + b + c + d + e + f + g == n) {
                min = i;
                System.out.println(i);
                break;
            } else if (i == n && min == 0) {
                System.out.println("0");
            }

        }
    }
}
