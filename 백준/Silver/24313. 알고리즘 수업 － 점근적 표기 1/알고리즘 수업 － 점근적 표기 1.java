import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int a1 = scanner.nextInt();
        int a0 = scanner.nextInt();

        int c = scanner.nextInt();

        int n0 = scanner.nextInt();

        int fn = a1*n0+a0;

        if (fn <= (c * n0) && c>=a1) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
