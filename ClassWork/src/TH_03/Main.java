package TH_03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SanPham laptop = new SanPham(), chuot = new SanPham(), banphim = new SanPham();
		System.out.println("Nhap thong  tinh cho sp");
		laptop.nhap(sc);
		chuot.nhap(sc);
		banphim.nhap(sc);
		laptop.hienThi();
		chuot.hienThi();
		banphim.hienThi();
	}

}
