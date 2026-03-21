import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[d+1];
        int[] dish = new int[N * 2];

        for (int i = 0; i<N; i++) {
            int number = Integer.parseInt(br.readLine());

            dish[i] = number;
            dish[i+N] = number;
        }
        int max = 0;
        int answer = 0;

        for (int i = 0; i<k; i++) {
            if (sushi[dish[i]] == 0) answer++;
            sushi[dish[i]]++;
        }
        max = answer;
        if (sushi[c] == 0) {
            max++;
            answer++;
        }
        sushi[c]++;

        for (int i = k; i<N+k; i++) {
            sushi[dish[i-k]]--;
            if (sushi[dish[i-k]]==0) answer--;
            if (sushi[dish[i]]==0) answer++;
            sushi[dish[i]]++;

            max = Math.max(answer, max);
        }

        System.out.println(max);
    }
}
