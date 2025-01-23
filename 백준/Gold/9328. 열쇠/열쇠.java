import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    static int y;
    static int x;
    static boolean[] alphabet;
    static ArrayList<int[]>[] list;
    static int count;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String str;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            count = 0;

            map = new char[y+2][x+2];
            visited = new boolean[y + 2][x + 2];
            alphabet = new boolean[26];
            list = new ArrayList[26];

            for (int j = 0; j < 26; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j <= y + 1; j++) {
                Arrays.fill(map[j], '.');
                if (j > 0 && j<=y) {
                    str = br.readLine();
                    for (int k = 1; k <= x; k++) {
                        map[j][k] = str.charAt(k - 1);
                    }
                }
            }

            str = br.readLine();
            if (str.charAt(0) != '0') {
                for (int j = 0; j < str.length(); j++) {
                        alphabet[str.charAt(j) - 'a'] = true;
                }
            }
            bfs();
            bw.write(Integer.toString(count) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (ny > y+1 || ny < 0 || nx > x + 1 || nx < 0) continue;

                if (map[ny][nx] != '*' && !visited[ny][nx]) {
                    if (map[ny][nx] - 'a' >= 0 && map[ny][nx] - 'a' < 26) {
                        alphabet[map[ny][nx]-'a'] = true;
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});

                        for (int[] next : list[map[ny][nx] - 'a']) {
                            queue.add(new int[]{next[0], next[1]});
                            visited[next[0]][next[1]] = true;
                        }
                        map[ny][nx] = '.';
                    } else if (map[ny][nx] - 'A' >= 0 && map[ny][nx] - 'A' < 26) {
                        if (alphabet[map[ny][nx] - 'A']) {
                            visited[ny][nx] = true;
                            queue.add(new int[]{ny, nx});
                            map[ny][nx] = '.';
                        } else {
                            list[map[ny][nx] - 'A'].add(new int[]{ny, nx});
                        }
                    } else if (map[ny][nx] == '$') {
                        map[ny][nx] = '.';
                        visited[ny][nx] = true;
                        count++;
                        queue.add(new int[]{ny, nx});
                    } else if (map[ny][nx] == '.'){
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny, nx});
                    }
                }
            }
        }
    }
}
