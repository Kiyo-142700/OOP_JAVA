package TH_03_Restar;

import java.util.Scanner;

import TH_02.Diem;

public class DoanThang {
	private Diem d1, d2;
	
	public DoanThang() {
		this.d1 = new Diem();
		this.d2 = new Diem();
	}
	
	public DoanThang(Diem d1, Diem d2) {
		this.d1 = new Diem(d1);
		this.d2 = new Diem(d2);
	}
	
	public DoanThang(int ax, int ay, int bx, int by) {
		this.d1 = new Diem(ax,ay);
		this.d2 = new Diem(bx, by);
	}
	
	public void nhap() {
		System.out.println("nhap toa do diem dau");
		this.d1.nhapDiem();
		System.out.println("nhap toa do diem cuoi");
		this.d2.nhapDiem();
	}
	
	public String toString () {
		return "Diem dau" + this.d1 + " Diem cuoi" + this.d2;// chỉ tự động gọi toString khi có ít nhất 1 chuỗi trong đó
	}
	
	public void tinhTien(int dx, int dy) {
		this.d1.doiDiem(dx, dy);
		this.d2.doiDiem(dx, dy);
	}
	
	public float doDai() {
		return d1.khoangCach(d2);
	}
	
	public float gocVoiTrucHoanh() {
		float canhhuyen, canhke, cos;
		canhhuyen = this.doDai();
		canhke = Math.abs(this.d1.giaTriX() - this.d2.giaTriX());
		cos = canhke / canhhuyen;
		cos = Math.max(-1.0f, Math.min(1.0f, cos));
		return (float) Math.toDegrees(Math.acos(cos));// acos ra radian nen can toDegrees de ra do
	}
	
}
