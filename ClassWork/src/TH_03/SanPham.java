package TH_03;

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
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.donGia = donGia;
	}
	
	public SanPham(SanPham sP) {
		if(sP != null) {// kiem tra null
			this.maSP = sP.maSP;
			this.tenSP = sP.tenSP;
			this.donGia = sP.donGia;
		}
	}
	
	public void nhap(Scanner sc) {
		System.out.println("Nhap ma san pham: ");
		this.maSP = sc.nextLine();
		System.out.println("Nhap ten san phan: ");
		this.tenSP = sc.nextLine();
		do {
			System.out.println("Nhap don gia: ");
			this.donGia = sc.nextDouble();
			sc.nextLine(); // xoa enter
			if(this.donGia < 0) {
				System.out.println("Khong hop le nhap lai!");
			}
		}while(this.donGia < 0);
	}
	
	@Override
    public String toString() {
        return "Ma SP: "+ maSP + " | Ten SP: " + tenSP + " | Don gia: "   + donGia;
    }
	
	public void hienThi() {
		System.out.println(this.toString());
	}
	
	public double tinhTienGiamGia(double phanTramGiam) {
		return this.donGia * (phanTramGiam/100);
	}
	
	public double tinhDonGiaSauGiam(double phanTramGiam) {
		return this.donGia - this.tinhTienGiamGia(phanTramGiam);
	}
	
	public String layTen() {
		return this.tenSP;
	}
	
	public double layDonGia() {
		return this.donGia;
	}
	
}
