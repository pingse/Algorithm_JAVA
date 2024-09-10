import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("");
        int[] alphabet = new int[26];
        Arrays.fill(alphabet, 0);
        int max = 0;
        int maxNum = 0;

        for (int i = 0; i < strings.length; i++) {
            if ((int)strings[i].charAt(0) > 90) {
                alphabet[(int)strings[i].charAt(0)-97] += 1;
            } else {
                alphabet[(int)strings[i].charAt(0)-65] += 1;
            }
        }
        for (int j = 0; j < alphabet.length; j++) {
            if (alphabet[j] != 0) {
                if (alphabet[j] > max) {
                    max = alphabet[j];
                    maxNum = j;
                }
            }
        }
        Arrays.sort(alphabet);
        char a = (char) (maxNum+ 65);
        for (int j = alphabet.length - 2; j >= 0; j--) {
            if (max == alphabet[j]) {
                a = 63;
            }
        }
        System.out.println(a);
    }
}
