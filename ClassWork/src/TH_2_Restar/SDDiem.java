package TH_2_Restar;

import java.util.Scanner;

public class SDDiem {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		Diem A = new Diem(3,4);
		System.out.println("toa do diem A: " + A);
		Diem B = new Diem();
		B.nhapDiem(sc);
		System.out.println("Toa do diem vua nhap B: " + B);
		Diem C = new Diem(-B.giaTriX(), -B.giaTriY());
		System.out.println("Diem doi xung voi diem B qua goc toa do la C: " + C);
		System.out.println("khoang cach tu diem B dem tam O la: " + B.khoangCach());
		System.out.println("Khoang cach tu diem A den diem B la: " + B.khoangCach(A));
		
	}

}
