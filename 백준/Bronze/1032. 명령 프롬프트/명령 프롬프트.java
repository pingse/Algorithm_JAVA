import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] dic = new String[n];

        for (int i = 0; i<n; i++) {
            dic[i] = br.readLine();
        }

        if (n == 0) {
            System.out.println(dic[0]);
            return;
        }

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i<dic[0].length(); i++) {
            boolean isSame = true;
            char cha = dic[0].charAt(i);
            for (int j = 1; j<n; j++) {
                if (cha != dic[j].charAt(i)) {
                    sb.append("?");
                    isSame = false;
                    break;
                }
            }
            if (isSame) sb.append(cha);
            else continue;
        }

        System.out.println(sb.toString());
    }
}
