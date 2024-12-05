import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static ArrayList<Integer> aList;
    static ArrayList<Integer> bList;
    static int index;
    static int C;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        aList = new ArrayList<>();
        bList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        aDFS(0, 0, N / 2);
        bDFS(0, N / 2, N);
        Collections.sort(bList);

        int ans = 0;
        for (int i = 0; i < aList.size(); i++) {
            index = -1;
            binarySearch(0, bList.size() - 1, aList.get(i));
            ans += index+1;
        }
        bw.write(Integer.toString(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    static void aDFS(int sum, int i, int limit) {
        if (sum > C) {
            return;
        }

        if (i == limit) {
            aList.add(sum);
            return;
        }
        aDFS(sum + arr[i], i + 1, limit);
        aDFS(sum, i + 1, limit);
    }

    static void bDFS(int sum, int i, int limit) {
        if (sum > C) {
            return;
        }

        if (i == limit) {
            bList.add(sum);
            return;
        }

        bDFS(sum + arr[i], i + 1, limit);
        bDFS(sum, i + 1, limit);
    }

    static void binarySearch(int start, int end, int val) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;

        if (bList.get(mid) + val <= C) {
            index = mid;
            binarySearch(mid + 1, end, val);
        } else {
            binarySearch(start, mid-1, val);
        }

    }

}
