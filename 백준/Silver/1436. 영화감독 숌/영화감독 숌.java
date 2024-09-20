import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.close();
        int i = 665;
        while (n != 0) {
            i++;
            if (String.valueOf(i).contains("666")) {
                n-=1;
            }
        }
        System.out.println(i);
    }
}
