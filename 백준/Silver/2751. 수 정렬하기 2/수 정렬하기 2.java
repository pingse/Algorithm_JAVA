import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(bufferedReader.readLine()));
        }
        bufferedReader.close();
        
        Collections.sort(numbers);

        for (int i : numbers) {
            bufferedWriter.write(i + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
