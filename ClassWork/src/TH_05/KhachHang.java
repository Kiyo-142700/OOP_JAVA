package TH_05;

import java.util.Scanner;

public class KhachHang {
	private String maKH, hoTen;
	
	public KhachHang() {
		this.maKH = new String();
		this.hoTen = new String();
	}
	
	public KhachHang(String maKH, String hoTen) {
		this.maKH = new String (maKH);
		this.hoTen = new String(hoTen);
	}
	
	public KhachHang(KhachHang t) {
		this.maKH = new String (t.maKH);
		this.hoTen = new String(t.hoTen);
	}
	
	public void nhap(Scanner sc) {
		
		do {
			System.out.print("Nhap ma khach hang: ");
			this.maKH = sc.nextLine();
			System.out.print("Nhap ho ten khach hang: ");
			this.hoTen = sc.nextLine();
			if(this.maKH.trim().isEmpty() || this.hoTen.trim().isEmpty()) {
				System.out.println("Khong hop le nhap lai");
			}
		}while(this.maKH.trim().isEmpty() || this.hoTen.trim().isEmpty());
	}
	
	@Override
	public String toString() {
		return "Ma KH: " + this.maKH + " | Ho ten: " + this.hoTen + "\n";
	}
	
	public void in() {
		System.out.print(this.toString());
	}
	
	
	
}
