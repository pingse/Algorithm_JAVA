import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int v = scanner.nextInt();
        scanner.close();

        System.out.println((v-b)%(a-b) == 0 ? (v-b)/(a-b) : ((v-b)/(a-b)+1));
    }
}
