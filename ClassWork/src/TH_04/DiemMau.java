package TH_04;

import java.util.Scanner;

import TH_2_Restar.Diem;

public class DiemMau extends Diem{
	private String mau;
	
	public DiemMau() {
		super();
		this.mau = new String();
	}
	
	public DiemMau(int x, int y, String mau) {
		super(x, y);// ham xay dung nen kieu v
		this.mau = mau;
	}
	
	public void GanMau(String mau) {
		this.mau = mau;
	}
	
	public void nhapDiemMau(Scanner sc) {
		System.out.println("Nhap toa do");
		super.nhapDiem(sc);// goi pt binh thuong
		System.out.print("Nhap mau: ");
		this.mau = sc.nextLine();
	}
	
	@Override
	public String toString() {
		return "Diem Mau co toa do " + super.toString() + " | Mau: " + this.mau + "\n";
	}
	
	public void hienThi() {
		System.out.print(this.toString());
	}
	
	
}
