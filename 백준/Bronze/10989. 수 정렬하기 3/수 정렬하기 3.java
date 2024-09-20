import java.io.*;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] numbers = new int[10001];
        for (int i = 0; i < n; i++) {
            numbers[Integer.parseInt(bufferedReader.readLine())]++;
        }
        bufferedReader.close();

        for (int i = 1; i < 10001; i++) {
            while (numbers[i] > 0) {
                bufferedWriter.write(i+"\n");
                numbers[i]--;
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
