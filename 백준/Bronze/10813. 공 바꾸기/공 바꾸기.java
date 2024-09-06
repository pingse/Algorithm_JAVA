import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] pocket = new int[n];
        int temp = 0;

        Arrays.setAll(pocket, i -> i+1);
        
        for (int k = 0; k < m; k++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            temp = pocket[a-1];
            pocket[a-1] = pocket[b-1];
            pocket[b-1] = temp;
        }

        for (int j = 0; j < n; j++) {
            System.out.print(pocket[j] + " ");
        }

    }
}
