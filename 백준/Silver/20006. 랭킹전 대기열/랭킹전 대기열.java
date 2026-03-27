import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static class Player {
        int lv;
        String id;

        public Player(int lv, String id) {
            this.lv = lv;
            this.id = id;
        }
    }

    static class Room {
        int baseLv;
        List<Player> players;

        public Room(int baseLv) {
            this.baseLv = baseLv;
            this.players = new ArrayList<>();
        }

        boolean canEnter(Player player) {
            boolean lvCheck = Math.abs(this.baseLv - player.lv) <= 10;
            boolean sizeCheck = players.size() < maxSize;

            return lvCheck && sizeCheck;
        }

        void add(Player player) {
            players.add(player);
        }
    }

    static int maxSize;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        maxSize = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            int lv = Integer.parseInt(st.nextToken());
            String id = st.nextToken();

            Player p = new Player(lv, id);

            boolean entered = false;

            for (Room room : rooms) {
                if (room.canEnter(p)) {
                    room.add(p);
                    entered = true;
                    break;
                }
            }

            if (!entered) {
                Room r = new Room(p.lv);
                r.add(p);
                rooms.add(r);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Room room : rooms) {

            if (room.players.size() == maxSize) {
                sb.append("Started!\n");
            } else {
                sb.append("Waiting!\n");
            }

            room.players.sort((a, b) -> a.id.compareTo(b.id));

            for (Player player : room.players) {
                sb.append(player.lv)
                        .append(" ")
                        .append(player.id)
                        .append("\n");
            }
        }

        System.out.println(sb);

    }
}
