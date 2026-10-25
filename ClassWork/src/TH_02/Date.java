package TH_02;

import java.util.Scanner;

public class Date {
	private int ngay, thang, nam;
	
	public Date() {
		this.ngay = 10;
		this.thang = 04;
		this.nam = 2007;
	}
	
	public Date(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}
	public Date(Date d) {
		this.ngay = d.ngay;
		this.thang = d.thang;
		this.nam = d.nam;
	}
	public void hienThi() {
		System.out.printf("%02d/%02d/%d\n", this.ngay, this.thang,this.nam);
		
	}	
	public String toString() {
		return String.format("%02d/%02d/%04d", ngay, thang, nam);
	}
	
	public boolean hopLe() {
		if(this.ngay < 1 || this.thang < 1 || this.thang > 12) {
			return false;
		}
		int d = 31;
		switch (this.thang) {
		case 4 : case 6: case 9: case 11: d = 30; break;
		case 2 : {
			if((this.nam % 400 == 0) || (this.nam % 4 == 0 && this.nam % 100 != 0)) {
				d = 29;
			}else {
				d = 28;
			}
			break;
		}
		}
		return this.ngay <= d? true : false;
		
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("nhap ngay: ");
			this.ngay = sc.nextInt();
			System.out.print("nhap thang: ");
			this.thang = sc.nextInt();
			System.out.print("nhap nam: ");
			this.nam = sc.nextInt();
			if(!hopLe()) {
				System.out.println("ngay thang nam nhap vao khong hop le nhap lai!");
			}
		}while(!hopLe());
	}
	
	public Date ngayHomSau() {
		Date d = new Date(this.ngay, this.thang, this.nam);
		d.ngay++;
		if(!d.hopLe()) {
			d.ngay   = 1;
			d.thang++;
			if(!d.hopLe()) {
				d.thang = 1;
				d.nam++;
			}
		}
		return d;
	}
	public Date congNgay(int n) {
		Date d = new Date(this.ngay, this.thang, this.nam);
		for(int i = 0; i < n ; i++) {
			d = d.ngayHomSau();
		}
		return d;
	}
	
	
	
}
