import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int temp = 0;
         while(true){
             if(N%5 == 0){
                    count += N/5;
                 System.out.println(count);
                 break;
             }else{
                 N -= 2;
                 count++;
             }
             if(N < 0){
                 System.out.println(-1);
                 break;
             }
         }
    }
}
