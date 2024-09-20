import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s1 = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        StringTokenizer stringTokenizer1 = new StringTokenizer(s1, " ");
        
        int n = Integer.parseInt(stringTokenizer1.nextToken());
        int k = Integer.parseInt(stringTokenizer1.nextToken());
        StringTokenizer stringTokenizer2 = new StringTokenizer(s2, " ");
        
        int[] numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(stringTokenizer2.nextToken());
        }
        Arrays.sort(numbers);
        System.out.println(numbers[numbers.length-k]);
    }
}
