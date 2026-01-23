import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        List<String[]> rank = new ArrayList<>();
        int tempRank = 0;
        int tempScore = 0;

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            str = str.replace("[", "")
                    .replace("]", "")
                    .replace("{", "")
                    .replace("}", "")
                    .replace("\"", "");

            String[] parts = str.split(",");

            String name = "";
            String score = "";
            String hidden = "";

            for (String part : parts) {
                String[] kv = part.split(":");

                if (kv[0].equals("name")) {
                    name = kv[1];
                } else if (kv[0].equals("score")) {
                    score = kv[1];
                } else {
                    hidden = kv[1];
                }
            }
            rank.add(new String[]{name, score, hidden});
        }

        Collections.sort(rank, (o1, o2) -> {
            if (o1[1].equals(o2[1])) {
                return o1[0].compareTo(o2[0]);
            } else {
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        for (int i = 1; i <= n; i++) {
            String[] info = rank.get(i - 1);
            int scoreVal = Integer.parseInt(info[1]);

            if (scoreVal != tempScore) {
                tempRank = i;
                tempScore = scoreVal;
            }

            if (!info[2].equals("1")) {
                bw.write(tempRank + " " + info[0] + " " + info[1] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
