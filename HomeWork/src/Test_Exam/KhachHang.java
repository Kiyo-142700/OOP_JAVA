package Test_Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class KhachHang {
	private String mso,hten, nsinh;
	private TaiKhoan dstk[];
	
	public KhachHang() {
		this.mso = new String();
		this.hten = new String();
		this.nsinh = new String();
		this.dstk = null;
	}
	
	public KhachHang(String mso, String hten, String nsinh, TaiKhoan dstk[]) {
		this.mso = mso;
		this.hten = hten;
		this.nsinh = nsinh;
		this.dstk = new TaiKhoan[dstk.length];
		for(int i =0; i < dstk.length; i++) {
			this.dstk[i] = new TaiKhoan(dstk[i]);
		}
	}
	
	public KhachHang(KhachHang t) {
		this.mso = t.mso;
		this.hten = t.hten;
		this.nsinh = t.nsinh;
		this.dstk = new TaiKhoan[t.dstk.length];
		for(int i =0; i < t.dstk.length; i++) {
			this.dstk[i] = new TaiKhoan(t.dstk[i]);
		}
	}
	
	public void nhap(Scanner sc) {
		System.out.print("Nhap ma so kh: ");
		this.mso = sc.nextLine();
		System.out.print("Nhap ho ten kh: ");
		this.hten = sc.nextLine();
		System.out.print("Nhap ngay sinh kh: ");
		this.nsinh = sc.nextLine();
		int n;
		do {
			System.out.print("Nhap so luong tk: ");
			n = sc.nextInt();
			sc.nextLine();
			if(n < 0) {
				System.out.println("khong hop le nhap lai!");
			}
		}while(n < 0);
		
		this.dstk = new TaiKhoan[n];
		for(int i = 0; i < n; i++) {
			dstk[i] = new TaiKhoan();
			dstk[i].nhap(sc);
		}
		
		
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Ma so: ").append(this.mso)
		.append("\nHo ten: ").append(this.hten)
		.append("\nNgay sinh: ").append(this.nsinh).append("\n");
		for(TaiKhoan e:this.dstk) {
			if(this.dstk != null) {// kiểm tra null để ko bị truy cập null
				if (e != null) result.append(e).append("\n");// kiểm tra null để ko bị truy cập null
			}
		}
		return result.toString();
	}
	
	public void in() {
		System.out.print(this.toString());
	}
	
	public long tongtien(char l) {
	    long tong = 0;
	    if (this.dstk != null) {//kiểm tra null
	        for (TaiKhoan e : this.dstk) {
	            if (e != null && e.loaiTK(l)) {
	                tong += e.laySoDu();
	            }
	        }
	    }
	    return tong;// ko nên return 0
	}
	
	public String layTen() {
		return this.hten;
	}
	
	public String layNS() {
		return this.nsinh;
	}
	
	public boolean sinhtrongthang(int m) {
	    if (this.nsinh == null || this.nsinh.isEmpty()) return false;
	    String[] parts = this.nsinh.split("/");// cắt từng thằng theo / rr bỏ vào chuỗi
	    // Theo đề (mm/dd/yyyy), tháng là parts[0]
	    if (parts.length >= 2) {//kiểm tra xem nhap dủ ngày tháng năm ko
	        return Integer.parseInt(parts[0].trim()) == m;
	    }
	    return false;
	}
	
	public boolean loaitk(char l) {
		for(int i = 0; i < this.dstk.length; i++) {
			if(this.dstk[i].loaiTK(l)) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so khach hang trong danh sach: ");
		int n = sc.nextInt();
		sc.nextLine();
		KhachHang ds[] = new KhachHang[n];
		for(int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin cho khach hang thu " + (i + 1) );
			ds[i] = new KhachHang();
			ds[i].nhap(sc);
		}
		
		ArrayList <KhachHang> p = new ArrayList<>();
		ArrayList <KhachHang> s = new ArrayList<>();
		ArrayList <KhachHang> l = new ArrayList<>();
		
		System.out.println("Danh sach khach hang vua nhap la");
		for(KhachHang e: ds) {
			e.in();
			if(e.loaitk('p')) {
				p.add(new KhachHang(e));
			}
			if(e.loaitk('s')) {
				s.add(new KhachHang(e));
			}
			if(e.loaitk('l')){
				l.add(new KhachHang(e));
			}
			
		}
		
		System.out.println("Khach hang co ngay sinh trong thang 8 la");
		for(KhachHang e : ds) {
			if(e.sinhtrongthang(8)) {
				System.out.println(e.layTen());
			}
		}
		
		System.out.println("thong ke khach hang theo loai tk");
		System.out.println("Tai khoan thanh toan");
		for(KhachHang e: p) {
			System.out.println(e.layTen());
		}
		
		System.out.println("Tai khoan tiet kiem");
		for(KhachHang e: s) {
			System.out.println(e.layTen());
		}
		
		System.out.println("Tai khoan vay");
		for(KhachHang e: l) {
			System.out.println(e.layTen());
		}
		
	}
	
	
}
