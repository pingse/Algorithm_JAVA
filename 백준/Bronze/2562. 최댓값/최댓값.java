import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int max = 0;
        int location = 0;

        int[] a = new int[9];


        for(int i = 0; i<9; i++){
            int b = sc.nextInt();
            a[i] = b;
            if(a[i] >= max){
                max = a[i];
                location = i+1;
            }
        }


        System.out.println(max);
        System.out.println(location);

    }
}