package Restar_Exam;

import java.util.Scanner;

public class KhachHang {
	private String mso, hten, nsinh;
	private TaiKhoan dsTK[];
	
	public KhachHang() {
		this.mso = new String();
		this.hten = new String();
		this.nsinh = new String();
		this.dsTK = null;
	}
	
	public KhachHang(String mso, String hten, String nsinh, TaiKhoan dsTK[]) {
		this.mso = new String(mso);
		this.hten = new String(hten);
		this.nsinh = new String(nsinh);
		if(dsTK != null) {
			this.dsTK = new TaiKhoan[dsTK.length];
			for(int i = 0; i < dsTK.length; i++) {
				this.dsTK[i] = new TaiKhoan(dsTK[i]);
			}
		}else {
			this.dsTK = null;
		}
	}
	
	public KhachHang(KhachHang t) {
		if(t != null) {
			this.mso = new String(t.mso);
			this.hten = new String(t.hten);
			this.nsinh = new String(t.nsinh);
			this.dsTK = new TaiKhoan[t.dsTK.length];
			if(t.dsTK != null) {
				for(int i = 0; i < t.dsTK.length; i++) {
					this.dsTK[i] = new TaiKhoan(t.dsTK[i]);
				}
			}else {
				this.dsTK = null;
			}
		}else {
			this.mso = new String();
			this.hten = new String();
			this.nsinh = new String();
			this.dsTK = null;
		}
	}
	
	public void nhap(Scanner sc) {
		System.out.print("Nhap ma so khach hang: ");
		this.mso = sc.nextLine();
		System.out.print("Nhap ho ten: ");
		this.hten = sc.nextLine();
		System.out.print("Nhap ngay sinh (mm/dd/yyyy): ");
		this.nsinh = sc.nextLine();
		int n;
		do {
			System.out.print("Nhap so luong tai khoan: ");
			n = sc.nextInt();
			sc.nextLine();
			if(n <= 0) {
				System.out.println("! khong hop le nhap lai");
			}
		}while(n <= 0);
		this.dsTK = new TaiKhoan[n];
		for(int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin cho tai khoang thu " + (i + 1));
			this.dsTK[i] = new TaiKhoan();
			this.dsTK[i].nhap(sc);
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(String.format("Ma so KH: %s | Ho ten: %s | Ngay sinh: %s\n", this.mso, this.hten, this.nsinh));
		for(int i = 0; i < this.dsTK.length;i++) {
			result.append("   +").append(this.dsTK[i].toString());
		}
		return result.toString();
				
	}
	
	public void hienThi() {
		System.out.print(this.toString());
	}
	
	public long tongtien(char l) {
		long tong = 0;
		if(this.dsTK != null) {
			for(int i = 0; i < this.dsTK.length; i++) {
				if(this.dsTK[i].loaiTK(l) && this.dsTK[i] != null) {
					tong += this.dsTK[i].laySoDu();
				}
			}
		}
		return tong;
	}
	
	public boolean sinhtrongthang(int m) {
		String tach[] = this.nsinh.split("/");
		if(tach.length > 3) {
			return false;
		}
		int thang;
		try {
			thang = Integer.parseInt(tach[0]);
		}catch(Exception e) {
			return false;
		}
		
		return thang == m;
		
	}
	
	public String getTen() {
		return this.hten;
	}
	
	public boolean loaiTK(char l) {
		if(this.dsTK == null) {
			return false;
		}
		for(int i = 0; i < this.dsTK.length; i++) {
			if(this.dsTK[i] != null && this.dsTK[i].loaiTK(l)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n;
		do {
			System.out.print("Nhap so khach hang trong danh sach: ");
			n = sc.nextInt();
			sc.nextLine();
			if(n <= 0) {
				System.out.println("Khong hop le nhap lai");
			}
		}while(n <= 0);
		KhachHang ds[] = new KhachHang[n];
		for(int i = 0; i < ds.length; i++) {
			ds[i] = new KhachHang();
			ds[i].nhap(sc);
		}
		System.out.println("Danh sach khach hang vua nhap la\n");
		for(KhachHang e : ds) {
			e.hienThi();
			System.out.println();
		}
		
		System.out.println("\n==============================================\n");
		System.out.println("Nhung khach hang sinh trong thang 8");
		for(KhachHang e : ds) {
			if(e.sinhtrongthang(8)) {
				System.out.println("   + " + e.getTen());
			}
		}
		
		System.out.println("\n==============================================\n");
		String TenTK[] = {"Thanh toan", "Tiet kiem", "Vay"};
		char dsTK[] = {'p', 's', 'l'};
		
		for(int i = 0; i < dsTK.length; i++) {
			System.out.println("Tai khoan " + TenTK[i]);
			boolean co = false;
			for(KhachHang e : ds) {
				if(e != null && e.loaiTK(dsTK[i])) {
					System.out.println("   + "+ e.getTen());
					co = true;
				}
			}
			if(!co) {
				System.out.println("   Khong co ai");
			}
		}
		
		
	}
	
	
}
