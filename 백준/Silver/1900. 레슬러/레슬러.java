import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Player {
        int idx;
        int p;
        int r;

        Player(int idx, int p, int r) {
            this.idx = idx;
            this.p = p;
            this.r = r;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Player[] players = new Player[n];

        for (int i = 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            players[i] = new Player(i+1, p, r);
        }

        Arrays.sort(players, (o1, o2) -> {
            long a = o1.p + (long)o2.p * o1.r;
            long b = o2.p + (long)o1.p * o2.r;

            if (a > b) return -1;
            else return 1;
        });

        StringBuilder sb = new StringBuilder();

        for(Player p : players){
            sb.append(p.idx).append("\n");
        }

        System.out.print(sb);
    }
}
