import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        Map<Character, Integer> temp = new HashMap<>();

        String[] strings = new String[T];

        int value = 9;

        for (int i = 0; i<T; i++) {
            String str = br.readLine();
            strings[i] = str;

            for (int j = 0; j<str.length(); j++) {
                int now = str.length() - j - 1;
                char c = str.charAt(j);

                temp.put(c, temp.getOrDefault(c, 0) + (int) Math.pow(10, now));
            }
        }

        List<Character> list = new ArrayList(temp.keySet());

        Collections.sort(list, (o1, o2) -> temp.get(o2) - temp.get(o1));

        for (int i = 0; i<list.size(); i++) {
            temp.put(list.get(i), value--);
        }

        long answer = 0;

        for (int i = 0; i<T; i++) {
            long convert = 0;
            for (int j = 0; j<strings[i].length(); j++) {
                convert *= 10;
                convert += temp.get(strings[i].charAt(j));
            }
            answer += convert;
        }

        System.out.println(answer);
    }
}
