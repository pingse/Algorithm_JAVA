import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[][] map = new char[10][10];
    public static void main(String[] args) throws IOException {

        int stick = 24;
        int square = 0;

        for (int i = 0; i<10; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i<10; i+=3) {
            for (int j = 0; j<10; j+=3) {
                if (j - 1 > 0 && map[i][j-1] == '-' && map[i][j-2] == '-') stick--;
                if (i - 1 > 0 && map[i-1][j] == '|' && map[i-2][j] == '|') stick--;
            }
        }

        for (int i = 1; i<=3; i++) {
            int len = 3*i;
            for (int j = 0; j+len<10; j+=3) {
                for (int k = 0; k+len<10; k+=3) {
                    if (isSquare(j, k, len)) square++;
                }
            }
        }

        System.out.println(stick + " " + square);
    }

    static boolean isSquare(int y, int x, int size) {
        for (int a = 0; a<size; a++) {
            if (map[y][x+a] == '.') return false;
            if (map[y+size][x+a] == '.') return false;
        }
        for (int a = 0; a<size; a++) {
            if (map[y+a][x] == '.') return false;
            if (map[y+a][x+size] == '.') return false;
        }

        return true;
    }
}
