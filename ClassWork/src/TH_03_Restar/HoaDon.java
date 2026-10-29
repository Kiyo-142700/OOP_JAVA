package TH_03_Restar;

import java.util.Scanner;

public class HoaDon {
	private String maHD;
	private SanPham sanPham;
	private int soLuong;
	
	public HoaDon() {
		this.maHD = new String();
		this.sanPham = new SanPham();
		this.soLuong = 0;
	}
	
	public HoaDon(String maHD, SanPham sanPham, int soLuong) {
		this.maHD = new String(maHD);
		this.sanPham = new SanPham(sanPham);
		this.soLuong = soLuong;
	}
	
	public HoaDon(HoaDon d) {
		this.maHD = new String(d.maHD);
		this.sanPham = new SanPham(d.sanPham);
		this.soLuong = d.soLuong;
	}
	
	public void nhap(Scanner sc, SanPham ds[]) {
		System.out.print("Nhap ma HD: ");
		this.maHD = sc.nextLine();
		int chon;
		System.out.println("Danh sach cach san pham ben duoi nhap san pham ban muon chon");
		for(int i = 0; i < ds.length; i++) {
			System.out.print((i+1) + ". ");
			ds[i].hienThi();
		}
		do {
			chon = sc.nextInt();
			sc.nextLine();
			if(chon <= 0 || chon > ds.length) {
				System.out.println("Khong hop le nhap lai!");
			}else {
				this.sanPham = new SanPham(ds[chon - 1]);
			}
		}while(chon <= 0 || chon > ds.length);
		do {
			System.out.print("Nhap so luong SP: ");
			this.soLuong = sc.nextInt();
			sc.nextLine();
			if(this.soLuong < 0) {
				System.out.println("Khong hop le nhap lai!");
			}
		}while(this.soLuong < 0);
	}
	
	@Override
	public String toString() {
		return "Ma HD: " + this.maHD + "\n"
				+ "   + SP: " + this.sanPham
				+ "   + So luong: " + this.soLuong
				+ String.format("\n   + Tong tien: %,.0f\n", this.tinhTongTien());
	}
	
	public void hienThi() {
		System.out.print(this.toString());
	}
	
	public double tinhTongTien() {
		return this.sanPham.layDonGia() * this.soLuong;
	}
	
	public double tinhTienGiamGia(double phanTramGiam) {
		return this.tinhTongTien() * (phanTramGiam/100);
	}
	
	public double tinhTienThanhToan(double phanTramGiam) {
		return this.tinhTongTien() - this.tinhTienGiamGia(phanTramGiam);
	}
	
	public String layHD() {
		return this.maHD;
	}
	
}
