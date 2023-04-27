import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int temp = 0;
        int[] a = new int[30];

        for(int i =0; i<28; i++){
            temp = sc.nextInt();
            for(int k = 1; k<=30; k++){
                if(k == temp){
                    a[k-1] = temp;
                }
            }
        }
        for(int i = 0; i<30; i++){
            if(a[i] == 0){
                System.out.println(i+1);
            }
        }
    }
}