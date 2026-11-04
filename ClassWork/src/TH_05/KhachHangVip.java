package TH_05;

import java.util.Scanner;

public class KhachHangVip extends KhachHang {
	private MyDate ngayGH;
	private float tiLeGiam;
	
	public KhachHangVip() {
		super();
		this.ngayGH = new MyDate();
		this.tiLeGiam = 0f;
	}
	
	public KhachHangVip(String maKH, String hoTen, MyDate ngayGH, float tiLeGiam) {
		super(maKH, hoTen);
		this.ngayGH = new MyDate(ngayGH);
		this.tiLeGiam = tiLeGiam;
	}
	
	public KhachHangVip(KhachHangVip t) {
		super(t);
		this.ngayGH = new MyDate(t.ngayGH);
		this.tiLeGiam = t.tiLeGiam;
	}
	
	public void nhap(Scanner sc) {
		super.nhap(sc);
		System.out.println("Nhap ngay gia han VIP");
		this.ngayGH.nhap(sc);
		do {
			System.out.print("Nhap ti le duoc giam cua khach hang VIP: ");
			this.tiLeGiam = sc.nextFloat();
			sc.nextLine();
			if(this.tiLeGiam < 0) {
				System.out.println("Khong hop le nhap lai");
			}
		}while(this.tiLeGiam < 0);
	}
	
	@Override
	public String toString() {
		return "VIP\n" + super.toString() + "Ngay gia han: "  + this.ngayGH.toString() + "\nTi le duoc giam: " + this.tiLeGiam +"%";
	}
	
	public void in() {
		System.out.print(this.toString());
	}
	
	
}
