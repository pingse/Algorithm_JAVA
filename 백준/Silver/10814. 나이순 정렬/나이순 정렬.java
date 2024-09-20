import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer stringTokenizer;
        int n = Integer.parseInt(bufferedReader.readLine());

        String[][] members = new String[n][2];

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            members[i][0] = stringTokenizer.nextToken();
            members[i][1] = stringTokenizer.nextToken();
        }
        bufferedReader.close();

        Arrays.sort(members, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return 1;
            } else {
                return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
            }
        }));

        for (int i = 0; i < n; i++) {
            bufferedWriter.write(members[i][0] + " " + members[i][1] + "\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
