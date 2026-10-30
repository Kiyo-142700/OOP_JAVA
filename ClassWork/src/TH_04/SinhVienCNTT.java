package TH_04;

import java.util.Scanner;

import TH_03_Restar.SinhVien;
import TH_2_Restar.Date;

public class SinhVienCNTT extends SinhVien{
	private String taikhoan, matkhau, email;
	
	public SinhVienCNTT() {
		super();
		this.taikhoan = new String();
		this.matkhau = new String();
		this.email = new String();
	}
	
	public SinhVienCNTT(String mssv,String hoten, Date ngaysinh, int soluonghp, String tenhp[], String diemhp[], String taikhoan, String matkhau, String email) {
		super(mssv, hoten, ngaysinh, soluonghp, tenhp, diemhp);
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.email = email;
	}
	
	public SinhVienCNTT(SinhVienCNTT t) {
		super(t);
		this.taikhoan = t.taikhoan;
		this.matkhau = t.matkhau;
		this.email = t.email;
	}
	
	public void nhapSVCNTT(Scanner sc) {
		super.nhap(sc);
		super.nhapDiem(sc, 0);
		System.out.print("Nhap tai khoan: ");
		this.taikhoan = sc.nextLine();
		System.out.print("Nhap mat khau: ");
		this.matkhau = sc.nextLine();
		System.out.print("Nhap email: ");
		this.email = sc.nextLine();
	}
	
	@Override
	public String toString() {
		return super.toString() + "Tai khoan: " + this.taikhoan + " | Mat khau: " + this.matkhau + " | Email: " + this.email + "\n";
	}
	
	public void hienThi() {
		System.out.print(this.toString());
	}
	
	public void doiMatKhau(String newpass) {
		this.matkhau = new String(newpass);
	}
	
	public String getEmail() {
		return this.email;
	}
	
	
	
	
	
}
