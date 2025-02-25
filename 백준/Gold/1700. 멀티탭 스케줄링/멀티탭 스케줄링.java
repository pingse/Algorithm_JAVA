import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;

        List<Integer> arr = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < k; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < k; i++) {
            if (set.contains(arr.get(i))) continue;
            if (set.size() < n) {
                set.add(arr.get(i));
                continue;
            }

            int max = -1;
            int idx = -1;

            for (int j : set) {
                int temp = 0;
                List<Integer> newArr = arr.subList(i + 1, k);
                if (newArr.contains(j)) {
                    temp = newArr.indexOf(j) + 1;
                } else {
                    temp = k - i - 1;
                }

                if (max < temp) {
                    max = temp;
                    idx = j;
                }
            }
            set.remove(idx);
            set.add(arr.get(i));
            answer++;
        }
        System.out.print(answer);
    }
}
