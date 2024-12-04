import java.io.*;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean[] prime;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        prime = new boolean[N + 1];

        prime[0] = prime[1] = true;

        for (int i = 2; i * i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i * i; j < prime.length; j+=i) {
                    prime[j] = true;
                }
            }
        }
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                arrayList.add(i);
            }
        }

        int start = 0;
        int end = 0;
        int value = 0;
        int sum = 0;

        while (true) {
            if (sum >= N) {
                sum -= arrayList.get(start++);
            } else if (end == arrayList.size()) {
                break;
            } else {
                sum += arrayList.get(end++);
            }
            if (sum == N) {
                value++;
            }
        }

        bw.write(Integer.toString(value));
        bw.flush();
        bw.close();
        br.close();
    }
}
