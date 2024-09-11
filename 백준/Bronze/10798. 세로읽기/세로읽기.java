import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[5][15];
        String word = "";


        for (int i = 0; i < 5; i++) {
            word = scanner.next();
            for (int j = 0; j < word.length(); j++) {
                matrix[i][j] = (char)word.charAt(j);
            }
        }

        for (int j = 0; j < 15; j++) {
            for (int k = 0; k < 5; k++) {
                if (matrix[k][j] != '\0') {
                    System.out.print(matrix[k][j]);
                }
            }
        }
    }
}
