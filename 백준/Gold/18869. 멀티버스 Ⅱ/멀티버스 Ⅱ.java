import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] num = new int[m][n];
        List<Integer>[] sortedNum = new ArrayList[m];


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < n; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
                set.add(num[i][j]);
            }
            sortedNum[i] = new ArrayList<>(set);
            Collections.sort(sortedNum[i]);
        }

        int[][] compressed = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                compressed[i][j] = Collections.binarySearch(sortedNum[i], num[i][j]);
            }
        }
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                if (Arrays.equals(compressed[i], compressed[j])) {
                    count++;
                }
            }
        }
        System.out.print(count);

    }
}
