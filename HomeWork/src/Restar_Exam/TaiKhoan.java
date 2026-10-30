package Restar_Exam;

import java.util.Scanner;

public class TaiKhoan {
	private String stk;
	private long sodu;
	private char loai;
	
	public TaiKhoan() {
		this.stk = new String();
		this.sodu = 0;
		this.loai = ' ';
	}
	
	public TaiKhoan(String stk, long sodu, char loai) {
		this.stk = stk;
		this.sodu = sodu;
		this.loai = loai;
	}
	
	public TaiKhoan(TaiKhoan d) {
		this.stk = d.stk;
		this.sodu = d.sodu;
		this.loai = d.loai;
	}
	
	public boolean loaiTK() {
		return this.loai == 'p' || this.loai == 's' || this.loai == 'l';
	}
	
	public boolean loaiTK(char l) {
		return this.loai == l;
	}
	
	public void nhap(Scanner sc) {
		System.out.print("Nhap so tai khoan: ");
		this.stk = sc.nextLine();
		do {
			System.out.print("Nhap so du: ");
			this.sodu = sc.nextLong();
			sc.nextLine();
			if(this.sodu < 0) {
				System.out.println("! khong hop le nhap lai");
			}
		}while(this.sodu < 0);
		
		
		do {
			System.out.print("Nhap loai tai khoan (p, s, l): ");
			this.loai = sc.nextLine().charAt(0);
			if(!this.loaiTK()) {
				System.out.println("Khong hop le nhap lai");
			}
		}while(!this.loaiTK());
		
	}
	
	@Override
	public String toString() {
		return String.format("STK: %s | So du: %,d | Loai: %c\n", this.stk, this.sodu, this.loai);
	}
	
	public void in() {
		System.out.print(this.toString());
	}
	
	public long laySoDu() {
		return this.sodu;
	}
	
	public static void main(String agrs[]) {
		Scanner sc = new Scanner (System.in);
		TaiKhoan tk1 = new TaiKhoan();
		tk1.nhap(sc);
		System.out.println("Thong tin cua tk1 la");
		System.out.println("   + " + tk1);
		
		System.out.println("\n=====================================");
		TaiKhoan tk2 = new TaiKhoan(tk1);
		System.out.println("Thong tin tk2 sao chep tu tk1 la");
		System.out.println("   + " + tk2);
		
		
		
	}
	
}
