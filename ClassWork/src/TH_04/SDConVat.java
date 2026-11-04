package TH_04;

import java.util.Arrays;
import java.util.Scanner;

public class SDConVat {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so con vat: ");
		int n = sc.nextInt();
		sc.nextLine();
		ConVat ds[] = new ConVat[n];
		for(int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin cho con vat thu "+ (i + 1));
			System.out.println("1. Bo | 2. Heo | 3. De");
			int chon = sc.nextInt();
			sc.nextLine();
			ds[i] = chon == 1? new Bo() : chon == 2? new Heo() : new De();
			ds[i].nhap(sc);
		}
		
		System.out.println("Thong tin " + n + " con vat va tieng keu vua nhap la");
		for(ConVat e:ds) {
			e.in();
			e.keu();
		}
		
		System.out.println("\n==========================================\n");
		
		System.out.println("Bo sung con ga");
		ConVat dsnew[] = Arrays.copyOf(ds, ds.length + 1);
		dsnew[n] = new Ga();
		dsnew[n].nhap(sc);
		for(ConVat e:dsnew) {
			e.in();
			e.keu();
		}
	}
	

}
