package TH_03;
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
		this.d1 = new Diem(ax, ay);
		this.d2 = new Diem(bx, by);
	}
	
	public void nhap() {
		System.out.println("nhap diem dau");
		this.d1.nhapDiem();
		System.out.println("nhap diem cuoi");
		this.d2.nhapDiem();
		
	}
	
	public String toString() {
		return this.d1.toString() + " " + this.d2.toString();
	}
	
	public void tinhTien(int dx, int dy) {
		this.d1.doiDiem(dx, dy);
		this.d2.doiDiem(dx, dy);
	}
	
	public float doDai() {
		return this.d1.khoangCach(d2);
	}
	
	public float gocVoiTrucHoanh() {
		float cosVal = Math.abs(d1.giaTriX() - d2.giaTriX()) / doDai();
		cosVal = Math.max(-1.0f, Math.min(1.0f, cosVal));
		return (float)Math.toDegrees(Math.acos(cosVal));
	}
	
	
	
}
