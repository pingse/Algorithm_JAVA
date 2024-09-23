import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new TreeMap<>(((o1, o2) -> o2.compareTo(o1)));

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            map.put(st.nextToken(), st.nextToken());
        }
        
        for (String key : map.keySet()) {
            if (map.get(key).equals("enter")) {
                System.out.println(key);
            }
        }
    }
}
