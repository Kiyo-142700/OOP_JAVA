package TH_2_Restar;

import java.util.Scanner;


public class Date {
	private int ngay, thang, nam;
	
	public Date() {
		this.ngay = 10;
		this.thang = 4;
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
	public String toString() {
		return String.format("%02d/%02d/%04d", this.ngay, this.thang, this.nam);// không nên để \n vì dễ xuống dòng đột ngột khi s.o.p ( "" + obj + "")
	}
	
	public void hienThi() {
		System.out.println(this.toString());// gọi toString cho nhanh
	}
	
	
	public boolean hopLe() {
		if(this.ngay < 1 || this.thang < 1 || this.thang > 12) {
			return false;
		}
		int d = 31;// cho nó là 31 chỉ cần kiểm năm nhuận và 30 khỏi default
		switch(this.thang) {
		case 4 : case 6 : case 9 : case 11: d = 30; break;
		case 2 : {
			if(this.nam % 400 == 0 || (this.nam % 4 == 0 && this.nam % 100 != 0)) {
				d = 29;
			}else {
				d = 28;
			}
		}; break;
		}
		return this.ngay <= d;// nó tự hiểu vì trà về là kiểu boolean
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("Nhap ngay: ");
			this.ngay = sc.nextInt();
			System.out.print("nhap thang: ");
			this.thang = sc.nextInt();
			System.out.print("nhap nam: ");
			this.nam = sc.nextInt();
			if(!hopLe()) {
				System.out.println("nhap vao khong hop le nhap lai!");
			}
		}while(!hopLe());
	}
	
	public Date ngayHomSau() {
		Date d = new Date(this.ngay, this.thang, this.nam);
		d.ngay++;
		if(!d.hopLe()) {
			d.ngay = 1;
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
		for(int i = 0; i < n; i++) {
			d = d.ngayHomSau();
		}
		return d;
	}
	
	
	
	
}
