package TH_05;

import java.util.Scanner;

public class MyDate {
	private int ngay, thang, nam;
	
	public MyDate() {
		this.ngay = 1;
		this.thang = 1;
		this.nam = 2026;
	}
	
	public MyDate(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}
	
	public MyDate(MyDate t) {
		this.ngay = t.ngay;
		this.thang = t.thang;
		this.nam = t.nam;
	}
	
	public boolean hopLe() {
		if(this.ngay < 1 || this.thang < 1 || this.thang >12) {
			return false;
		}
			int d = 31;
			switch(this.thang) {
			case 4 : case 6 : case 9 : case 11 : d = 30; break;
			case 2 : {
				if(this.nam % 400 == 0 || (this.nam % 4 == 0 && this.nam % 100 != 0)) {
					
				}
			} break;
			}
		return this.ngay <= d ? true : false;
	}
	
	
	public void nhap(Scanner sc) {
		do {
			System.out.print("Nhap ngay: ");
			this.ngay = sc.nextInt();
			sc.nextLine();
			System.out.print("Nhap thang: ");
			this.thang = sc.nextInt();
			sc.nextLine();
			System.out.print("Nhap nam: ");
			this.nam = sc.nextInt();
			sc.nextLine();
			if(!hopLe()) {
				System.out.println("Kong hop le nhap lai");
			}
		}while(!hopLe());
		
	}
	
	@Override
	public String toString() {
		return this.ngay + "/" + this.thang + "/" + this.nam;
	}
	
	public void in() {
		System.out.print(this.toString());
	}
	
	
}
