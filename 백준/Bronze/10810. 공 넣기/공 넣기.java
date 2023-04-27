import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];

        for(int s = 0; s<m; s++){
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            for (int c = i-1; c<j; c++){
                a[c] = k;
            }
        }
        for (int s = 0; s<n; s++) {
            System.out.print(a[s]+" ");
        }

    }
}