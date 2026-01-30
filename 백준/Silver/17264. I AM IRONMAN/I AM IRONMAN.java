import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<String, String> players = new HashMap<>();

        st = new StringTokenizer(br.readLine(), " ");

        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int endScore = Integer.parseInt(st.nextToken());
        int score = 0;

        for (int i = 0; i<P; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            players.put(st.nextToken(), st.nextToken());
        }

        for (int i = 0; i<N; i++) {
            String name = br.readLine();

            if (players.containsKey(name)) {
                if (players.get(name).equals("W")) {
                    score += w;
                    if (score >= endScore) {
                        System.out.println("I AM NOT IRONMAN!!");
                        return;
                    }
                } else {
                    score -= l;
                    if (score < 0) score = 0;
                }
            } else {
                score -= l;
                if (score < 0) score = 0;
            }
        }
        System.out.println("I AM IRONMAN!!");
    }
}
