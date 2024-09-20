import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer;
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] matrix = new int[n][2];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            matrix[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            matrix[i][1] = Integer.parseInt(stringTokenizer.nextToken());
        }
        bufferedReader.close();

        Arrays.sort(matrix, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        }));
        for (int i = 0; i < n; i++) {
            bufferedWriter.write(matrix[i][0] + " " + matrix[i][1] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
