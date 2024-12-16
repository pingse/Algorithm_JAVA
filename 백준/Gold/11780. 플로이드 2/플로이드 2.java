import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Bus {
        int v;
        int price;

        public Bus(int v, int price) {
            this.v = v;
            this.price = price;
        }
    }

    static int[][] matrix;
    static int[][] result;
    static int INF = 10000001;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;

        matrix = new int[n + 1][n + 1];
        result = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    matrix[i][j] = INF;
                }
                result[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            matrix[u][v] = Math.min(matrix[u][v], price);
            result[u][v] = u;

        }
        floyd();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                bw.write(matrix[i][j] != INF ? Integer.toString(matrix[i][j]) + " " : "0 ");
            }
            bw.write("\n");
        }
        path(n);
        bw.flush();
        bw.close();
        br.close();

    }

    static void floyd() {
        for (int k = 1; k < matrix.length; k++) {
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix.length; j++) {
                    if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                        result[i][j] = result[k][j];
                    }
                }
            }
        }
    }

    static void path(int n) throws IOException {

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (result[i][j] == INF) {
                    bw.write("0\n");
                } else {
                    int end = j;

                    stack.push(end);

                    while (i != result[i][end]) {
                        end = result[i][end];
                        stack.push(end);
                    }

                    stack.push(i);
                    bw.write(Integer.toString(stack.size()) + " ");
                    while (!stack.isEmpty()) {
                        bw.write(Integer.toString(stack.pop()) + " ");
                    }
                    bw.write("\n");
                }
            }
        }
    }


}
