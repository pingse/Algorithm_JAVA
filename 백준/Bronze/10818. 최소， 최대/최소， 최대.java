import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int min = 1000000;
        int max = -1000000;

        int[] a = new int[n];


        for(int i = 0; i<n; i++){
            int b = sc.nextInt();
            a[i] = b;
            if(a[i] <= min){
                min = a[i];
            }
            if(a[i] >= max){
                max = a[i];
            }
        }

        System.out.print(min + " " + max);

    }
}