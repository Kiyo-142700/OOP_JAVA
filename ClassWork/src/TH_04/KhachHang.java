package TH_04;

import java.util.Scanner;

public abstract class KhachHang {
	private String mkh, hoten, nsinh, gtinh, sdt, dchi, mso;
	
	public KhachHang() {
		this.mkh = new String();
		this.hoten = new String();
		this.nsinh = new String();
		this.gtinh = new String();
		this.sdt = new String();
		this.dchi = new String();
		this.mso = new String();
	}
	
	public KhachHang(String mkh, String hoten, String nsinh, String gtinh, String sdt, String dchi, String mso) {
		this.mkh = new String(mkh);
		this.hoten = new String(hoten);
		this.nsinh = new String(nsinh);
		this.gtinh = new String(gtinh);
		this.sdt = new String(sdt);
		this.dchi = new String(dchi);
		this.mso = new String(mso);
	}
	
	public KhachHang(KhachHang t) {
		this.mkh = new String(t.mkh);
		this.hoten = new String(t.hoten);
		this.nsinh = new String(t.nsinh);
		this.gtinh = new String(t.gtinh);
		this.sdt = new String(t.sdt);
		this.dchi = new String(t.dchi);
		this.mso = new String(t.mso);
	}
	
	public void nhap(Scanner sc) {
		System.out.print("Nhap ma khach hang: ");
		this.mkh = sc.nextLine();
		System.out.print("Nhap ho ten: ");
		this.hoten = sc.nextLine();
		System.out.print("Nhap ngay sinh: ");
		this.nsinh = sc.nextLine();
		System.out.print("Nhap gioi tinh: ");
		this.gtinh = sc.nextLine();
		System.out.print("Nhap so dien thoai: ");
		this.sdt = sc.nextLine();
		System.out.print("Nhap dia chi: ");
		this.dchi = sc.nextLine();
		System.out.print("Nhap ma so: ");
		this.mso = sc.nextLine();
		
	}
	
	@Override
	public String toString() {
		return String.format("   + MKH: %-10s | Ho ten: %40s | Ngay sinh: %14s | Gioi tinh: %-10s | SDT: %14s | Dia chi: %44s | Ma so: %10s", this.mkh, this.hoten, this.nsinh, this.gtinh, this.sdt, this.dchi, this.mso);
	}
	
	public void in() {
		System.out.print(this.toString());
	}
	
	
	public abstract double tinhTien(int sanluong);
	
	public String getTen() {
		return this.hoten;
	}
	
	public String getMKH() {
		return this.mkh;
	}

	
	
	
}
