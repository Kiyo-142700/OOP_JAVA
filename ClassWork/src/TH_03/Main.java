package TH_03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SanPham ds[] = new SanPham[3];
		ds[0] = new SanPham("SP01", "laptop", 44000000);
		ds[1] = new SanPham("SP02", "chuot", 540000);
		ds[2] = new SanPham("SP03", "ban phim", 740000);
		
		System.out.println("thong tin cac sp la");
		for(SanPham e: ds) {
			e.hienThi();
		}
		
		HoaDon dientu[] = new HoaDon[5];
		for(int i = 0; i < 5; i++) {
			dientu[i] = new HoaDon();
			dientu[i].nhap(sc, ds);
		}
		int t = 0;
		double tong = 0.0;
		double tien;
		HoaDon max = dientu[0];
		for(HoaDon e: dientu) {
			e.hienThi();
			tien = e.tinhTienThanhToan(10);
			tong += tien;
			System.out.println("tien thanh toan: " + tien);
			if(max.tinhTienThanhToan(10) < tien) {
				max = e;
			}
			if(tien > 10000000) {
				t++;
			}
		}
		
		System.out.println("Tong tien thanh toan cua cac hoa don: " + tong);
		
		System.out.println("hoa don co co gia tri lon nhat: " + max.layHD());
		
		System.out.println("so hoa don tren 10.000.000: " + t);
		
	}

}
