import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
        Map<String, Integer> map = new HashMap<>();
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        int count = 0;

        for (int i = 0; i < n; i++) {
            map.put(bufferedReader.readLine(), 1);
        }
        for (int i = 0; i < m; i++) {
            if (map.get(bufferedReader.readLine()) != null) {
                count++;
            }
        }
        System.out.println(count);

    }
}
