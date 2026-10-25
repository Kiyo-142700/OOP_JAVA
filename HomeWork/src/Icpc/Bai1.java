package Icpc;
import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int t =0;
            int N = 0;
            N = sc.nextInt();
            int ds[] = new int[N];
            for(int j = 0; j<N; j++) {
            	ds[j] = sc.nextInt();
            	if(ds[j] % 2 == 0) {
            		t ++;
            	}
            }
            if(t % 2 == 0) {
            	System.out.println("YES");
            }else {
            	System.out.println("NO");
            }
        }
    }
}