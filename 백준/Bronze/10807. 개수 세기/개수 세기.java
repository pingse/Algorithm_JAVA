import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int[] b = new int[a];

        for (int i = 0; i<a; i++){
            int c = sc.nextInt();
            b[i] = c;
        }

        int d = sc.nextInt();
        int count = 0;
        for(int i = 0; i<a; i++){
            if(b[i] == d){
                count += 1;
            }
        }

        System.out.println(count);

    }
}