package TH_05;

import java.util.Scanner;

public class HoaDon {
	private String maHD;
	private MyDate ngayHD;
	private KhachHang kh;
	private double triGia;
	
	public HoaDon() {
		this.maHD = new String();
		this.ngayHD = new MyDate();
		this.kh = new KhachHang();
		this.triGia = 0;
	}
	
	public HoaDon(String maHD, MyDate ngayHD, KhachHang kh, double triGia) {
		this.maHD = new String(maHD);
		this.ngayHD = new MyDate(ngayHD);
		// Xử lý copy constructor an toàn cho cả KhachHang và KhachHangVip
		if (kh instanceof KhachHangVip) {
			this.kh = new KhachHangVip((KhachHangVip) kh);
		} else {
			this.kh = new KhachHang(kh);
		}
		this.triGia = triGia;
	}
	
	public HoaDon(HoaDon t) {
		this.maHD = new String(t.maHD);
		this.ngayHD = new MyDate(t.ngayHD);
		this.kh = new KhachHang(t.kh);
		this.triGia = t.triGia;
	}
	
	public void nhap(Scanner sc, int n) {
		do {
			System.out.print("Nhap ma hoa don: ");
			this.maHD = sc.nextLine();
			if(this.maHD.trim().isEmpty()) {
				System.out.println("Khong hop le nhap lai");
			}
		}while(this.maHD.trim().isEmpty());
		System.out.println("Nhap ngay xuat hoa don");
		this.ngayHD.nhap(sc);
		System.out.println("Nhap thong tin khach hang");
		if(n == 0) {
			this.kh.nhap(sc);
		}else {
			this.kh = new KhachHangVip();
			this.kh.nhap(sc);
		}
		do {
			System.out.print("Nhap gia tri hoa don: ");
			this.triGia = sc.nextDouble();
			sc.nextLine();
			if(this.triGia < 0) {
				System.out.println("Khong hop le nhap lai");
			}
		}while(this.triGia < 0);
	}
	
	@Override
	public String toString() {
		return "Ma HD: " + this.maHD + " | Ngay xuat HD: " + this.ngayHD.toString() + " | Thanh tien: " + this.triGia + "\n" + this.kh.toString();
	}
	
	public void in() {
		System.out.print(this.toString());
	}
	
}
