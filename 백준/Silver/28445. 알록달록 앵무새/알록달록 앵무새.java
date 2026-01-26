import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        Set<String> colors = new HashSet<>();
        String str;

        while ((str = br.readLine()) != null && !str.isEmpty()) {
            st = new StringTokenizer(str);
            colors.add(st.nextToken());
            colors.add(st.nextToken());
        }

        List<String> colorList = new ArrayList<>(colors);

        Collections.sort(colorList);

        for (int i = 0; i<colorList.size(); i++) {
            for (int j = 0; j<colorList.size(); j++) {
                bw.write(colorList.get(i) + " " + colorList.get(j) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
