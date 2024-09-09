import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] numbers = sc.next().split("");
        int ans = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].charAt(0) - 65 < 3) {
                ans = ans + 3;
            } else if (3 <= numbers[i].charAt(0) - 65 && numbers[i].charAt(0) - 65 < 6) {
                ans = ans + 4;
            } else if (6 <= numbers[i].charAt(0) - 65 && numbers[i].charAt(0) - 65 < 9) {
                ans = ans + 5;
            } else if (9 <= numbers[i].charAt(0) - 65 && numbers[i].charAt(0) - 65 < 12) {
                ans = ans + 6;
            } else if (12 <= numbers[i].charAt(0) - 65 && numbers[i].charAt(0) - 65 < 15) {
                ans = ans + 7;
            } else if (15 <= numbers[i].charAt(0) - 65 && numbers[i].charAt(0) - 65 < 19) {
                ans = ans + 8;
            } else if (19 <= numbers[i].charAt(0) - 65 && numbers[i].charAt(0) - 65 < 22) {
                ans = ans + 9;
            } else {
                ans = ans + 10;
            }
        }
        System.out.println(ans);
    }
}
