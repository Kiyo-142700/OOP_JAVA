package TH_04;

public class KhachHangKinhDoanh extends KhachHang{

	public KhachHangKinhDoanh() {
		super();
	}
	
	public KhachHangKinhDoanh(String mkh, String hoten, String nsinh, String gtinh, String sdt, String dchi, String mso) {
		super(mkh, hoten, nsinh, gtinh, sdt, dchi, mso);
	}
	
	public KhachHangKinhDoanh(KhachHangSinhHoat t) {
		super (t);
	}
	
	
	@Override
	public double tinhTien(int sanluong) {
		return sanluong * 2800;
	}
	
	@Override
    public String toString() {
        return "[Kinh Doanh] " + super.toString();
    }
	
}
