package TH_03;

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
	
	public HoaDon(String maHD, SanPham sP,int soLuong ) {
		this.maHD = maHD;
		this.sanPham = new SanPham(sP);
		this.soLuong = soLuong;
	}
	
	public void nhap(Scanner sc, SanPham dsSP[]) {
		System.out.println("Nhap ma hoa don: ");
		this.maHD = sc.nextLine();
		System.out.println("Danh sach san pham hien co");
		for(int i = 0; i < dsSP.length; i++) {
			System.out.println("[" + (i + 1) +"]");
			dsSP[i].hienThi();
		}
		System.out.println("Chon san pham ban muon mua");
		int chon = 0;
		do{
				System.out.println("Chon trong danh sach" + 1 + " den " + dsSP.length + ": ");
				chon = sc.nextInt();
				if(chon < 1 || chon > dsSP.length) {
					System.out.println(chon < 1? "Khong hop le (phai >= 1)" : chon > dsSP.length? "Khong hop le ( phai <= " + dsSP.length + ")" : "");
				}
		}while(chon < 1 || chon > dsSP.length);
		
		this.sanPham = new SanPham(dsSP[chon - 1]);
		System.out.println("Ban da chon san pham: " + this.sanPham.layTen());
		System.out.print("Nhap so luong: ");
		this.soLuong = sc.nextInt();
		sc.nextLine();
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
	
	@Override
	public String toString() {
		return String.format("Hoa don: %s\nSan pham: %s\nSo luong: %d\nTong tien: %,.0lf",this.maHD, this.sanPham.layTen(), this.tinhTongTien());
	}
	
	public void hienThi() {
		System.out.println(this);
	}
	
}
