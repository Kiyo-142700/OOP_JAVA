package TH_04;

import java.util.Scanner;

public class HoaDon {
	private String maHD;
	private int csdau, cscuoi;
	private KhachHang kh;
	
	
	public void nhap(Scanner sc) {
		System.out.print("Nhap ma hoa don: ");
		this.maHD = sc.nextLine();
		System.out.println("Chon loai khach hang (1. Sinh hoat | 2. Kinh doanh): ");
        int chon = sc.nextInt();
        sc.nextLine();
        if (chon == 1) {
            this.kh = new KhachHangSinhHoat();
        } else {
            this.kh = new KhachHangKinhDoanh();
        }
        this.kh.nhap(sc);
		do {
			System.out.print("Nhap chi so dau: ");
			this.csdau = sc.nextInt();
			sc.nextLine();
			System.out.print("Nhap chi so cuoi: ");
			this.cscuoi = sc.nextInt();
			sc.nextLine();
			if(this.cscuoi < 0 || this.csdau < 0 || (this.csdau > this.cscuoi) ) {
				System.out.println("Khong hop le nhap lai");
			}
		}while(this.cscuoi < 0 || this.csdau < 0 || (this.csdau > this.cscuoi) );
		System.out.println("Nhap thong tin khach hang");
		
	}
	
	@Override
    public String toString() {
        return String.format("Ma HD: %-6s | %s | Chi so: %d -> %d | San luong: %d kWh | Thanh tien: %,.0f VND",
                this.maHD, this.kh.toString(), this.csdau, this.cscuoi, tinhSanLuong(), tienThanhToan());
    }
	
	public void in() {
		System.out.print(this.toString());
	}
	
	public int tinhSanLuong() {
        return this.cscuoi - this.csdau;
    }
	
	public double tienThanhToan() {
		return this.kh.tinhTien(this.tinhSanLuong());
	}
	
	public String getMHD() {
		return this.maHD;
	}
	
	public KhachHang getKH() {
		return this.kh;
	}
	
	
}
