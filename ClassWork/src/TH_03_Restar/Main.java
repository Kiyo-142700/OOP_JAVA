package TH_03_Restar;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so san pham muon tao: ");
		int n = sc.nextInt();
		sc.nextLine();
		SanPham ds[] = new SanPham[n];
		for(int i = 0; i < n; i++) {
			System.out.println("Nhap thon tin cho san pham thu " + (i + 1) + ": ");
			ds[i] = new SanPham();
			ds[i].nhap(sc);
		}
		
		System.out.println("Cac san pham vua nhap la\n");
		for(SanPham e:ds) {
			e.hienThi();
		}
		
		System.out.println("\n============================================\n");
		
		HoaDon dsHD[] = new HoaDon[5];
		for(int i = 0; i < 5; i++) {
			dsHD[i] = new HoaDon();
			dsHD[i].nhap(sc, ds);
		}
		
		
		HoaDon max = new HoaDon(dsHD[0]);
		double tong = 0;
		double tien;
		int t = 0;
		System.out.println("\nCac hoa don vua nhap la\n");
		for(HoaDon e:dsHD) {
			e.hienThi();
			tien = e.tinhTienThanhToan(10);
			System.out.format("   + Tien thanh toan: %,.0f\n", tien);
			tong += tien;
			if(max.tinhTienThanhToan(10) < tien) {
				max = e;
			}
			if(tien > 10000000) {
				t++;
			}
		}
		
		System.out.println("\n============================================\n");
		
		System.out.format("Tong tien thanh toan cua %d hoa don tren la %,.0f\n",dsHD.length, tong);
		
		System.out.println("\n============================================\n");
		
		System.out.println("Hoa don co tong tien thanh toan lớn nhất la: " + max.layHD());
		
		System.out.println("\n============================================\n");
		
		System.out.println("So hoa don tren 10,000,000 la: " + t);
		
		
	}

}
