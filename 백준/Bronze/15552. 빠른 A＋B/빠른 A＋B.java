import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(bf.readLine());

        for (int i = 0; i < a; i++) {
            String st = bf.readLine();
            int b = Integer.parseInt(st.split(" ")[0]);
            int c = Integer.parseInt(st.split(" ")[1]);
            bw.write(b + c + "\n");
        }
        bw.close();
    }
}