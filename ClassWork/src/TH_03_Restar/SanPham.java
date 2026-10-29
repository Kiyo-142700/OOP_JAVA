package TH_03_Restar;

import java.util.Scanner;

public class SanPham {
	private String maSP, tenSP;
	private double donGia;
	
	public SanPham() {
		this.maSP = new String();
		this.tenSP = new String();
		this.donGia = 0;
	}
	
	public SanPham(String maSP, String tenSP, double donGia) {
		this.maSP = new String(maSP);
		this.tenSP = new String(tenSP);
		this.donGia = donGia;
	}
	
	public SanPham(SanPham d) {
		this.maSP = new String(d.maSP);
		this.tenSP = new String(d.tenSP);
		this.donGia = d.donGia;
	}
	
	public void nhap(Scanner sc) {
		System.out.print("Nhap ma san pham: ");
		this.maSP = sc.nextLine();
		System.out.print("Nhap ten san pham: ");
		this.tenSP = sc.nextLine();
		do {
			System.out.print("Nhap gia san pham: ");
			this.donGia = sc.nextDouble();
			sc.nextLine();
			if(this.donGia < 0) {
				System.out.println("khong hop le nhap lai!");
			}
		}while(this.donGia < 0);
		
	}
	
	@Override
	public String toString() {
		return String.format("Ma SP: %s | Ten SP: %s | Don gia: %,.0f\n", this.maSP, this.tenSP, this.donGia);
	}
	
	public void hienThi() {
		System.out.print(this.toString());
	}
	
	public double tinhTienGiamGia(double phanTramGiam) {
		return this.donGia * (phanTramGiam/100);
	}
	
	public double tinhDonGiaSauGiam(double phanTramGiam) {
		return this.donGia - this.tinhTienGiamGia(phanTramGiam);
	}
	
	public double layDonGia() {
		return this.donGia;
	}
	
	
	
}
