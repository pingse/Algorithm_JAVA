import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        scanner.nextLine();

        String[] board = new String[row];
        for (int i = 0; i < row; i++) {
            board[i] = scanner.nextLine();
        }

        int sol = Integer.MAX_VALUE;
        for (int i = 0; i <= row - 8; i++) {
            for (int j = 0; j <= col - 8; j++) {
                int cursol = minChangeValue(i,j,board);
                if (sol > cursol) {
                    sol = cursol;
                }
            }
        }
        System.out.println(sol);
    }

    private static int minChangeValue(int i, int j, String[] board) {
        int countBlack = 0;
        int countWhite = 0;
        String[] exBoard = {"BWBWBWBW", "WBWBWBWB"};
        for (int k = 0; k < 8; k++) {
            for (int z = 0; z < 8; z++) {
                if (board[i+k].charAt(j+z) != exBoard[k % 2].charAt(z)) {
                    countBlack+=1;
                }
            }
        }
        for (int k = 0; k < 8; k++) {
            for (int z = 0; z < 8; z++) {
                if (board[i + k].charAt(j + z) != exBoard[k%2 == 0 ? 1 : 0].charAt(z)) {
                    countWhite +=1;
                }
            }
        }

        return countBlack>=countWhite ? countWhite : countBlack;
    }
}
