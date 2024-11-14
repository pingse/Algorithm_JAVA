import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int[] counting = new int[1000001];
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            counting[arr[i]] += 1;
        }

        stack.push(0);
        for (int i = 1; i < N; i++) {
            int size = stack.size();
            for (int j = 0; j < size; j++) {
                if (counting[arr[i]] > counting[arr[stack.peek()]]) {
                    arr[stack.pop()] = arr[i];
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        if (stack.size() > 0) {
            int s = stack.size();
            for (int i = 0; i < s; i++) {
                arr[stack.pop()] = -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            bw.write(Integer.toString(arr[i]) + " ");
        }
        bw.flush();
        bw.close();
    }
}
