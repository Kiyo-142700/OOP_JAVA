package TH_2_Restar;

import java.util.Scanner;

public class SDDate {

	public static void main(String[] args) {
		Date d0 = new Date();
		System.out.println("ngay mac dinh khi khoi tao la: " + d0);
		System.out.println("nhap ngay");
		Date d1 = new Date();
		d1.nhap();
		System.out.println("ngay vua nhap la: " + d1);
		Date d2 = d1.ngayHomSau();
		System.out.println("ngay hom sau la: " + d2);
		System.out.print("nhap so ngay muon tinh: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Date d3 = d1.congNgay(n);
		System.out.println("ngay sau khi cong la: " + d3);
		
	}

}
