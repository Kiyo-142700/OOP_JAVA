package TH_03_Restar;

import java.util.Scanner;

public class Gach {
	private String maso, mau;
	private int soluong, chieudai, chieungang;
	private long giaban;
	
	public Gach() {
		this.maso = new String();
		this.mau = new String();
		this.soluong = 0;
		this.chieudai = 0;
		this.chieungang = 0;
		this.giaban = 0;
	}
	
	public Gach(String maso, String mau, int soluong, int chieudai, int chieungang, long giaban) {
		this.maso = maso;
		this.mau = mau;
		this.soluong = soluong;
		this.chieudai = chieudai;
		this.chieungang = chieungang;
		this.giaban = giaban;
	}
	
	public Gach(Gach a) {
		this.maso = a.maso;
		this.mau = a.mau;
		this.soluong = a.soluong;
		this.chieudai = a.chieudai;
		this.chieungang = a.chieungang;
		this.giaban = a.giaban;
	}
	
	public void nhap(Scanner sc) {// truyền scanner khỏi tốn bộ nhớ
		System.out.print("nhap maso: ");
		this.maso = sc.nextLine();
		System.out.print("nhap mau: ");
		this.mau = sc.nextLine();
		System.out.print("nhap so luong trong 1 hop: ");
		this.soluong = sc.nextInt();
		System.out.print("nhap chieu dai: ");
		this.chieudai = sc.nextInt();
		System.out.print("nhap chieu ngang: ");
		this.chieungang = sc.nextInt();
		System.out.print("nhap gia ban 1 hop: ");
		this.giaban = sc.nextLong();
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("maso: ").append(this.maso)
		.append("\nmau: ").append(this.mau)
		.append("\nso luong: ").append(this.soluong)
		.append("\nchieu dai: ").append(this.chieudai)
		.append("\nchieu ngang: ").append(this.chieungang)
		.append("\ngia ban 1 hop: ").append(this.giaban).append("\n");
		return s.toString();
	}
	
	public void in() {
		System.out.println(this);
	}
	
	public float giaBanLe() {
		return this.giaban * 1.2f / this.soluong;
	}
	
	public int dienTichToiDa() {
		return this.chieudai * this.chieungang * this.soluong;
	}
	
	public int soluonggach(int D, int N) {
		int soluongdai = (D + this.chieudai - 1)/this.chieudai;// công thức cộng dư (a + (b-1))/b
		int soluongngang = (N + this.chieungang - 1)/this.chieungang;
		return soluongdai * soluongngang;
	}
	
	public int soLuongHop(int D, int N) {
		return (soluonggach(D, N) + this.soluong - 1)/this.soluong;
	}
	
	public float chiPhi() {
		return (float) this.giaban / this.dienTichToiDa();
	}
	
	public long getGiaBan() {
		return this.giaban;
	}
	
	
	
}
