package TH_05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong hoa don: ");
		int n = sc.nextInt();
		sc.nextLine();
		HoaDon ds[] = new HoaDon[n];
		for(int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin cho hoa don thu " + (i + 1));
			ds[i] = new HoaDon();
			int chon;
			do {
				System.out.println("HD nay cua KH thuong (0) hay VIP (1)");
				chon = sc.nextInt();
				sc.nextLine();
				if(chon > 0 && chon < 1) {
					System.out.println("Khong hop le chon lai");
				}
			}while(chon < 0 && chon > 1);
			ds[i].nhap(sc, chon);
		}
		
		System.out.println("THONG TIN HOA DON\n");
		for(HoaDon e: ds) {
			e.in();
			System.out.println();
		}
		
	}

}
