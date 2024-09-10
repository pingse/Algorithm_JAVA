import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 0);

        int temp = 0;
        int count = 0;
        int badcount = 0;

        for (int j = 0; j < n; j++) {
            String[] strings = scanner.next().split("");
            count += 1;
            for (int k = 0; k < strings.length; k++) {
                if (temp != strings[k].charAt(0)-97) {
                    if (alphabet[strings[k].charAt(0) - 97] != 0) {
                        badcount += 1;
                    }
                }
                temp = strings[k].charAt(0) - 97;
                alphabet[strings[k].charAt(0)-97] += 1;
            }
            if (badcount != 0) {
                count -= 1;
            }
            badcount = 0;
            Arrays.fill(alphabet, 0);
        }

        System.out.println(count);
    }
}
