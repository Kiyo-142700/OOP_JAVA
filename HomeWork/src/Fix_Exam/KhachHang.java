package Fix_Exam;

import java.util.Scanner;

public class KhachHang {
	private String mso, hten, nsinh;
	private TaiKhoan dstk[];
	private int n; // Số lượng tài khoản của khách hàng
	
	// Hàm xây dựng mặc định
	public KhachHang() {
		this.mso = new String();
		this.hten = new String();
		this.nsinh = new String();
		this.dstk = null;
		this.n = 0;
	}
	
	// Hàm xây dựng sao chép sâu (Deep Copy mảng đối tượng)
	public KhachHang(KhachHang t) {
		if (t != null) {
			this.mso = new String(t.mso);
			this.hten = new String(t.hten);
			this.nsinh = new String(t.nsinh);
			this.n = t.n;
			if (t.dstk != null) {
				this.dstk = new TaiKhoan[t.n];
				for (int i = 0; i < t.n; i++) {
					this.dstk[i] = new TaiKhoan(t.dstk[i]);
				}
			} else {
				this.dstk = null;
			}
		} else {
			this.mso = new String();
			this.hten = new String();
			this.nsinh = new String();
			this.dstk = null;
			this.n = 0;
		}
	}
	
	public void nhap(Scanner sc) {
		System.out.print("Nhap ma so khach hang: ");
		this.mso = sc.nextLine();
		System.out.print("Nhap ho ten khach hang: ");
		this.hten = sc.nextLine();
		System.out.print("Nhap ngay sinh (mm/dd/yyyy): ");
		this.nsinh = sc.nextLine();
		
		do {
			System.out.print("Nhap so luong tai khoan cua khach hang nay: ");
			this.n = sc.nextInt();
			sc.nextLine();
			if (this.n < 0) {
				System.out.println("So luong khong hop le, nhap lai!");
			}
		} while (this.n < 0);
		
		this.dstk = new TaiKhoan[this.n];
		for (int i = 0; i < this.n; i++) {
			System.out.println("  -> Nhap tai khoan thu " + (i + 1) + ":");
			this.dstk[i] = new TaiKhoan();
			this.dstk[i].nhap(sc);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("Ma so: ").append(this.mso)
		      .append(" | Ho ten: ").append(this.hten)
		      .append(" | Ngay sinh: ").append(this.nsinh).append("\n");
		
		if (this.dstk != null) {
			for (int i = 0; i < this.n; i++) {
				if (this.dstk[i] != null) {
					result.append("     + ").append(this.dstk[i].toString()).append("\n");
				}
			}
		}
		return result.toString();
	}
	
	public void in() {
		System.out.print(this.toString());
	}
	
	// Tính tổng số tiền theo loại tài khoản (p, s, l)
	public long tongtien(char l) {
		long tong = 0;
		if (this.dstk != null) {
			for (int i = 0; i < this.n; i++) {
				if (this.dstk[i] != null && this.dstk[i].loaiTK(l)) {
					tong += this.dstk[i].laySoDu();
				}
			}
		}
		return tong;
	}
	
	public String layTen() {
		return this.hten;
	}
	
	// Xử lý cắt chuỗi ngày sinh định dạng mm/dd/yyyy bằng split thông minh, chống lỗi văng ngoại lệ
	public boolean sinhtrongthang(int m) {
		if (this.nsinh == null || this.nsinh.isEmpty()) return false;
		String[] parts = this.nsinh.split("/");
		if (parts.length >= 1) {
			try {
				int thang = Integer.parseInt(parts[0].trim());
				return thang == m;
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return false;
	}
	
	// Kiểm tra khách hàng có sở hữu loại tài khoản 'l' nào không
	public boolean loaitk(char l) {
		if (this.dstk == null) return false;
		for (int i = 0; i < this.n; i++) {
			if (this.dstk[i] != null && this.dstk[i].loaiTK(l)) {
				return true;
			}
		}
		return false;
	}
	
	// Hàm main thực hiện toàn bộ yêu cầu phần B của đề thi
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap so luong khach hang trong danh sach: ");
		int nKH = sc.nextInt();
		sc.nextLine();
		
		KhachHang ds[] = new KhachHang[nKH];
		for (int i = 0; i < nKH; i++) {
			System.out.println("\n--- NHAP THONG TIN KHACH HANG THU " + (i + 1) + " ---");
			ds[i] = new KhachHang();
			ds[i].nhap(sc);
		}
		
		System.out.println("\n==============================================");
		System.out.println("DANH SACH TAT CA KHACH HANG VUA NHAP:");
		for (KhachHang e : ds) {
			if (e != null) {
				e.in();
			}
		}
		
		// Ý 1: Hiển thị họ tên khách hàng có ngày sinh trong tháng 08
		System.out.println("\n==============================================");
		System.out.println("1. KHACH HANG CO NGAY SINH TRONG THANG 08:");
		boolean foundAugust = false;
		for (KhachHang e : ds) {
			if (e != null && e.sinhtrongthang(8)) {
				System.out.println("   - " + e.layTen());
				foundAugust = true;
			}
		}
		if (!foundAugust) {
			System.out.println("   (Khong co khach hang nao sinh trong thang 08)");
		}
		
		// Ý 2: Thống kê họ tên khách hàng theo loại tài khoản (Dùng mảng tĩnh tối ưu, không dùng ArrayList)
		System.out.println("\n==============================================");
		System.out.println("2. THONG KE KHACH HANG THEO LOAI TAI KHOAN:");
		char[] loais = {'p', 's', 'l'};
		String[] tenLoais = {"Thanh toan (p)", "Tiet kiem (s)", "Vay (l)"};
		
		for (int i = 0; i < loais.length; i++) {
			System.out.println("-> Loai tai khoan: " + tenLoais[i]);
			boolean foundType = false;
			for (KhachHang e : ds) {
				if (e != null && e.loaitk(loais[i])) {
					System.out.println("   + " + e.layTen());
					foundType = true;
				}
			}
			if (!foundType) {
				System.out.println("   (Khong co)");
			}
		}
		
		sc.close();
	}
}