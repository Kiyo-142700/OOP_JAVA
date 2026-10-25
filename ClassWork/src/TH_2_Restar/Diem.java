package TH_2_Restar;

import java.util.Scanner;

public class Diem {
	private int x, y;
	
	public Diem() {
		this.x = 0;
		this.y = 0;
	}
	
	public Diem(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void nhapDiem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap vao toa do diem x:");
		this.x = sc.nextInt();
		System.out.println("Nhap vao toa do diem y:");
		this.y = sc.nextInt();
	}
	
	public void hienThi() {
		System.out.println("(" + this.x + ", " + this.y + ")");
	}
	
	public String toString() {
		return "(" + this.x + ", " + this.y + ")";
	}
	
	public void doiDiem(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	
	public int giaTriX() {
		return this.x;
	}
	
	public int giaTriY() {
		return this.y;
	}
	
	public float khoangCach() {
		return (float) Math.sqrt(this.x * this.x + this.y * this.y);
	}
	
	public float khoangCach(Diem d) {
		int x = this.x - d.x;
		int y = this.y -d.y;
		return (float) Math.sqrt(x*x + y*y);
	}
	
	
	
	
}
