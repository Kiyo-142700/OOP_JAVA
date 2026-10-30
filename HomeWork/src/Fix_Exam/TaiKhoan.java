package Fix_Exam;

import java.util.Scanner;

public class TaiKhoan {
	private String stk;
	private long sodu;
	private char loai;
	
	// Hàm xây dựng mặc định (chuẩn new String())
	public TaiKhoan() {
		this.stk = new String();
		this.sodu = 0;
		this.loai = ' ';
	}
	
	// Hàm xây dựng 3 tham số
	public TaiKhoan(String stk, long sodu, char loai) {
		this.stk = new String(stk);
		this.sodu = sodu;
		this.loai = loai;
	}
	
	// Hàm xây dựng sao chép (Deep copy + Check null an toàn)
	public TaiKhoan(TaiKhoan t) {
		if (t != null) {
			this.stk = new String(t.stk);
			this.sodu = t.sodu;
			this.loai = t.loai;
		} else {
			this.stk = new String();
			this.sodu = 0;
			this.loai = ' ';
		}
	}
	
	// Kiểm tra loại tài khoản có hợp lệ không (p, s, l)
	public boolean loaiTK() {
		return this.loai == 'p' || this.loai == 's' || this.loai == 'l';
	}
	
	// Kiểm tra loại tài khoản có khớp với tham số truyền vào không
	public boolean loaiTK(char l) {
		return this.loai == l;
	}
	
	public void nhap(Scanner sc) {
		System.out.print("  + Nhap so tai khoan: ");
		this.stk = sc.nextLine();
		
		do {
			System.out.print("  + Nhap so du tai khoan: ");
			this.sodu = sc.nextLong();
			sc.nextLine();
			if (this.sodu < 0) {
				System.out.println("  ! So du khong hop le, nhap lai!");
			}
		} while (this.sodu < 0);
		
		do {
			System.out.print("  + Nhap loai tai khoan (p/s/l): ");
			String input = sc.nextLine();
			if (input.length() > 0) {
				this.loai = input.charAt(0);
			} else {
				this.loai = ' ';
			}
			if (!this.loaiTK()) {
				System.out.println("  ! Loai tai khoan khong hop le, nhap dung ky tu p, s hoac l!");
			}
		} while (!this.loaiTK());
	}
	
	@Override
	public String toString() {
		return String.format("STK: %s | Loai: %c | So du: %,d đ", this.stk, this.loai, this.sodu);
	}
	
	public void in() {
		System.out.println(this.toString());
	}
	
	public long laySoDu() {
		return this.sodu;
	}
	
	public char layL() {
		return this.loai;
	}
	
	// Hàm main test riêng lớp TaiKhoan theo yêu cầu phần A của đề thi
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== TEST LOP TAI KHOAN ===");
		TaiKhoan tk1 = new TaiKhoan();
		tk1.nhap(sc);
		System.out.println("\nThong tin tai khoan tk1:");
		tk1.in();
		
		TaiKhoan tk2 = new TaiKhoan(tk1);
		System.out.println("\nThong tin tk2 (sao chep sau tu tk1):");
		tk2.in();
		sc.close();
	}
}