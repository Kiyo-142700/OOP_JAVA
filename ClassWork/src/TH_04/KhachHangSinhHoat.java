package TH_04;

public class KhachHangSinhHoat extends KhachHang {
	
	public KhachHangSinhHoat() {
		super();
	}
	
	public KhachHangSinhHoat(String mkh, String hoten, String nsinh, String gtinh, String sdt, String dchi, String mso) {
		super(mkh, hoten, nsinh, gtinh, sdt, dchi, mso);
	}
	
	public KhachHangSinhHoat(KhachHangSinhHoat t) {
		super (t);
	}
	
	
	
	
	@Override
	public double tinhTien(int sanluong) {
		if(sanluong <= 100) {
			return sanluong*2000.0;
		}else {
			return (sanluong - 100) * 3000.0 + 100*2000.0;
		}
	}
	
	@Override
    public String toString() {
        return "[Sinh Hoat] " + super.toString();
    }
	
	
}
