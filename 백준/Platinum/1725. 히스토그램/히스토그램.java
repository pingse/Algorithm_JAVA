import java.io.*;
import java.util.Stack;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int length = 0;
        int size = 0;
        int height = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        stack.push(0);
        for (int i = 1; i < N; i++) {
            while (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
                height = arr[stack.pop()];
                length = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, length * height);
            }
            stack.push(i);
        }
        while (stack.size() > 0) {
            height = arr[stack.pop()];
            length = stack.isEmpty() ? arr.length : arr.length - stack.peek() - 1;

            maxArea = Math.max(maxArea, length * height);
        }

        bw.write(Integer.toString(maxArea));
        bw.flush();
        bw.close();
    }
}
