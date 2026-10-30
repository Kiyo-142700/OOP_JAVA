package TH_03;
import TH_02.Diem;
public class SDDoanThang {
	public static void main(String[] args) {
		Diem A = new Diem(2, 5);
		Diem B = new Diem(20, 35);
		System.out.println("Diem A " + A);
		System.out.println("Diem B " + B);
		DoanThang AB = new DoanThang(A, B);
		System.out.println("Doan thang AB " + AB);
		AB.tinhTien(5, 3);
		System.out.println("Doan thang AB sau khi tinh tien " + AB);
		DoanThang CD = new DoanThang();
		CD.nhap();
		System.out.println("doan thang CD " + CD + " co do dai la: " + CD.doDai());
		System.out.println("goc voi truc hoanh la: " + CD.gocVoiTrucHoanh());
		
	}

}
