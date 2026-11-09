package TH_04;

import java.util.ArrayList;
import java.util.Scanner;

public class DanhSachHoaDon {
	private ArrayList <HoaDon> ds;
	
	public DanhSachHoaDon() {
		this.ds  = new ArrayList<>();
	}
	
	public DanhSachHoaDon(ArrayList <HoaDon> ds) {
		this.ds  = new ArrayList<>(ds);
	}
	
	public void nhap(Scanner sc) {
		System.out.print("Nhap so luong hoa don: ");
		int n = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			System.out.println("\n--- Nhập thông tin hóa đơn thứ " + (i + 1) + " ---");
			HoaDon t = new HoaDon();
			t.nhap(sc);
			ds.add(t);
		}
	}
	
	@Override
	public String toString() {
		if (ds.isEmpty()) {
            return "Danh sach hoa don trong!";
        } else {
        	StringBuilder result = new StringBuilder();
    		for(int i = 0; i < ds.size(); i++) {
    			result.append(this.ds.get(i).toString()).append("\n");
    		}
    		return result.toString();
        }
		
	}
	
	public void in() {
		System.err.print(this.toString());
	}
	
	public void them(Scanner sc) {
		System.out.println("THEM HOA DON");
        HoaDon t = new HoaDon();
        t.nhap(sc);
		this.ds.add(t);
	}
	
	public void xoa(HoaDon t) {
		int i = 0;
		for( ;i < ds.size(); i++) {
			if(ds.get(i).getMHD().equalsIgnoreCase(t.getMHD()) || ds.get(i).getKH().getMKH().equalsIgnoreCase(t.getKH().getMKH())) {
				break;
			}
		}
		if(i < ds.size()) {
			ds.remove(i);
		}else {
			System.out.println("Khong tim thay");
		}
	}
	
	public void capNhat(HoaDon t) {
		int i = 0;
		for( ;i < ds.size(); i++) {
			if(ds.get(i).getMHD().equalsIgnoreCase(t.getMHD()) || ds.get(i).getKH().getMKH().equalsIgnoreCase(t.getKH().getMKH())) {
				break;
			}
		}
		if(i < ds.size()) {
			ds.set(i , t);
		}else {
			System.out.println("Khong tim thay");
		}
	}
	

	
	
}
