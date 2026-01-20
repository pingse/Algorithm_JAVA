import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] board = new int[4][4];
    public static void main(String[] args) throws IOException {
        int turn = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean end = false;

        while(true) {
            String line = br.readLine();
            if (line == null) break;

            st = new StringTokenizer(line);
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            board[y][x] = turn;

            if (check(y, x, turn)) {
                end = true;
                break;
            }

            if (turn == 2) turn = 1;
            else turn = 2;
        }

        System.out.println(end ? turn : "0");
    }
    static boolean check(int y, int x, int turn) {
        return checkRow(y, turn)
                || checkCol(x, turn)
                || (y == x && checkDiag(turn))
                || (y + x == 4 && checkAntiDiag(turn));
    }

    static boolean checkRow(int y, int turn) {
        for (int i = 1; i <= 3; i++) {
            if (board[y][i] != turn) return false;
        }
        return true;
    }

    static boolean checkCol(int x, int turn) {
        for (int i = 1; i <= 3; i++) {
            if (board[i][x] != turn) return false;
        }
        return true;
    }

    static boolean checkDiag(int turn) {
        for (int i = 1; i <= 3; i++) {
            if (board[i][i] != turn) return false;
        }
        return true;
    }

    static boolean checkAntiDiag(int turn) {
        for (int i = 1; i <= 3; i++) {
            if (board[i][4 - i] != turn) return false;
        }
        return true;
    }
}
