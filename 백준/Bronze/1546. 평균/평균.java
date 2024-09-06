import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double[] scores = new double[n];
        double max = 0;
        double sum = 0;

        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();

        }
        for (int j = 0; j < n; j++) {
            if (max < scores[j]) {
                max = scores[j];
            }
        }
        for (int k = 0; k < n; k++) {
            scores[k] = scores[k]/max*100;
            sum += scores[k];
        }

        System.out.println(sum/n);

    }
}
