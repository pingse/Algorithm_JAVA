import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] chairs;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(br.readLine());
            return;
        }

        chairs = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j<n; j++) {
                chairs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = findReward(0, 0, n/2);

        System.out.println(answer);
    }

    static int findReward(int y, int x, int range) {
        List<Integer> list = new ArrayList<>();
        if (range == 1) {
            list.add(chairs[y][x]);
            list.add(chairs[y][x+1]);
            list.add(chairs[y+1][x]);
            list.add(chairs[y+1][x+1]);
            Collections.sort(list);
            return list.get(1);
        }

        list.add(findReward(y, x, range/2));
        list.add(findReward(y, x + range, range/2));
        list.add(findReward(y+range, x, range/2));
        list.add(findReward(y+range, x+range, range/2));

        Collections.sort(list);
        return list.get(1);
    }
}
