import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int fullMoney = 5000000;
    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i<t; i++) {

            List<Integer> list = new ArrayList<>();

            while(true) {
                int value = Integer.parseInt(br.readLine());
                if (value == 0) break;
                list.add(value);
            }

            int count = list.size();
            int money = 0;

            Collections.sort(list, Collections.reverseOrder());

            for (int j = 0; j<count; j++) {
                money += (2*(int)Math.pow(list.get(j), j+1));

                if (money > fullMoney) break;
            }

            if (money > fullMoney) {
                System.out.println("Too expensive");
            } else {
                System.out.println(money);
            }
        }
    }
}
