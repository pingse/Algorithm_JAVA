import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] n = new int[30];

        for (int i = 0; i < 28; i++) {
            int p = sc.nextInt();

            n[p-1] = p;
        }
        for (int j = 0; j < 30; j++) {
            if (n[j] == 0) {
                System.out.println(j + 1);
            }
        }
    }
}
