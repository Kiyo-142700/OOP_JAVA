package TH_02;

import java.util.Scanner;

public class SDDate {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.print("ngay mac dinh cua he thong la: ");
		d.hienThi();
		System.out.println("nhap vao ngay thang nam hien tai");
		Date d1 = new Date();
		d1.nhap();
		System.out.print("ngay thang nam vua nhap la: ");
		d1.hienThi();
		Date d2 = d1;
		System.out.print("ngay hom sau la: ");
		d1.ngayHomSau().hienThi();
		Scanner sc = new Scanner (System.in);
		System.out.print("nhap so ngay muon cong: ");
		int n = sc.nextInt();
		d2.congNgay(n).hienThi();
		
	
	}

}
