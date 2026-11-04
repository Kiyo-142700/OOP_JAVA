package TH_04;

import java.util.Scanner;

public abstract class ConVat {
	private String giong, maulong;
	private float cannang;
	
	public ConVat() {
		this.giong = new String();
		this.maulong = new String();
		this.cannang = 0.0f;
	}
	
	public ConVat(String giong, String maulong, float cannang) {
		this.giong = new String(giong);
		this.maulong = new String(maulong);
		this.cannang = cannang;
	}
	
	public ConVat(ConVat t) {
		this.giong = new String(t.giong);
		this.maulong = new String(t.maulong);
		this.cannang = t.cannang;
	}
	
	public void nhap(Scanner sc) {
		System.out.print("Nhap giong: ");
		this.giong = sc.nextLine();
		System.out.print("Nhap mau long: ");
		this.maulong = sc.nextLine();
		do {
			System.out.print("Nhap can nang: ");
			this.cannang = sc.nextFloat();
			sc.nextLine();
			if(this.cannang <= 0) {
				System.out.println("Khong hop le nhap lai");
			}
		}while(this.cannang <= 0f);
	}
	
	
	@Override
	public String toString() {
		return "[Giong: " + this.giong + " | Mau long: " + this.maulong + " | Can nang: " + this.cannang + "Kg ]\n";
	}
	
	public void in() {
		System.out.print(this.toString());
	}
	
	public abstract void keu();
	
}
