package TH_03_Restar;

import TH_02.Diem;

public class SDDoanThang {
	public static void main(String args[]) {
		Diem A = new Diem(2, 5);
		Diem B = new Diem(20, 35);
		System.out.println("Diem A" + A);
		System.out.println("Diem B" + B);
		DoanThang AB = new DoanThang(A, B);
		System.out.println("Doan thang AB " + AB);
		AB.tinhTien(5, 3);
		System.out.println("Doan thang AB sau khi tinh tien di doan (5,3) la: " + AB);
		DoanThang CD = new DoanThang();
		CD.nhap();
		System.out.println("Doan thang vua nhap CD " + CD);
		System.out.format("Do dai doan thang CD: %.2f\n", CD.doDai());
		System.out.println("Goc cua CD voi truc hoanh la: \n" + CD.gocVoiTrucHoanh());
	}
}
