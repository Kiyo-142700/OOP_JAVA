package Test_Exam;

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
	
	public TaiKhoan(TaiKhoan t) {
	    if (t != null) {
	        this.stk = new String(t.stk); // Ép chuẩn new String()
	        this.sodu = t.sodu;
	        this.loai = t.loai;
	    }
	}
	
	public boolean loaiTK() {
	    return this.loai == 'p' || this.loai == 's' || this.loai == 'l';//tối ưu
	}
	
	public boolean loaiTK(char l) {
		return this.loai == l;
	}
	
	public void nhap(Scanner sc) {
		System.out.print("Nhap so tai khoan: ");
		this.stk = sc.nextLine();
		
		do {
			System.out.print("Nhap so du tai khoan: ");
			this.sodu = sc.nextLong();
			sc.nextLine();
			if(this.sodu < 0) {
				System.out.println("Khong hop le nhap lai!");
			}
		}while(this.sodu < 0);
		
		
		do {
			System.out.print("Nhap nhap loai tai khoan: ");
			this.loai = sc.nextLine().charAt(0);
			if(!this.loaiTK()) {
				System.out.println("Khong hop le nhap dung loai (p, s, l)");
			}
			
		}while(!this.loaiTK());
		
		
	}
	
	@Override
	public String toString() {
		return "STK: " + this.stk + " | Loai TK: " + this.loai + " | So du: " + this.sodu;
	}
	
	public void in() {
		System.out.println(this.toString());
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		TaiKhoan tk1 = new TaiKhoan();
		tk1.nhap(sc);
		System.out.println("Thong tin tai khoan tk1\n" + tk1);
		TaiKhoan tk2 = new TaiKhoan(tk1);
		System.out.println("Thong tin tk2 sao chep sau tu tk1\n" + tk2);
		
	}
	
	public long laySoDu() {
		return this.sodu;
	}
	
	public char layL() {
		return this.loai;
	}
}
