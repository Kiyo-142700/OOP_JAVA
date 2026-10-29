package TH_04;

import java.util.Scanner;

public class SDDiemMau {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		DiemMau A = new DiemMau(5, 10, "Trang");
		A.hienThi();
		
		System.out.println("\n==============================================");
		
		DiemMau B = new DiemMau();
		System.out.println("Nhap thon tin cho diem mau B");
		B.nhapDiemMau(sc);
		System.out.println("B\n   + " + B);
		
		
		System.out.println("\n==============================================");
		
		B.doiDiem(10, 8);
		System.out.println("B sau khi doi (10, 8)\n   + " + B);
		
		System.out.println("\n==============================================");
		
		B.GanMau("Vang");
		System.out.println("B sau khi gan mau vang\n   + " + B);
		
		
		
	}
}
