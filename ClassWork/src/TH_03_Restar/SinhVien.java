package TH_03_Restar;

import java.util.Scanner;


import TH_2_Restar.Date;

public class SinhVien implements Comparable<SinhVien>{// bản hợp đồng
	private String mssv, hoten;
	private Date ngaysinh;
	private int soluonghp;
	private String tenhp[], diemhp[];
	
	public SinhVien() {
		this.mssv = new String();
		this.hoten = new String();
		this.ngaysinh = new Date();
		this.soluonghp = 0;
		this.tenhp = new String[60];
		this.diemhp = new String[60];
	}
	
	public SinhVien(String mssv,String hoten, Date ngaysinh, int soluonghp, String tenhp[], String diemhp[]) {
		this.mssv = mssv;
		this.hoten = hoten;
		this.ngaysinh = new Date(ngaysinh);
		this.soluonghp = soluonghp;
		this.tenhp = new String[60];//phải khởi tạo mảng
		this.diemhp = new String[60];
		for(int i = 0; i < this.soluonghp; i++) {// nếu là String thì length có () còn mảng thì ko
			this.tenhp[i] = new String();
			this.tenhp[i] = tenhp[i];
			this.diemhp[i] = new String();
			this.diemhp[i] = diemhp[i];
			
		}
	}
	
	public SinhVien(SinhVien s) {
		this.mssv = s.mssv;
		this.hoten = s.hoten;
		this.ngaysinh = new Date(s.ngaysinh);
		this.soluonghp = s.soluonghp;
		this.tenhp = new String[60];//phải khởi tạo mảng
		this.diemhp = new String[60];
		for(int i = 0; i < s.soluonghp; i++) {
			this.tenhp[i] = new String(s.tenhp[i]);// không cần new String trước
			this.diemhp[i] = new String(s.diemhp[i]);
		}
		
	}	
	
	@Override
	public int compareTo(SinhVien t) {// nạp đè
		return this.layTen().compareTo(t.layTen());
	}
	
	public void nhap(Scanner sc) {
		System.out.println("Nhap mssv: ");
		this.mssv = sc.nextLine();
		System.out.println("Nhap ho ten sinh vien: ");
		this.hoten = sc.nextLine();
		System.out.println("Nhap ngay sinh cua sinh vien: ");
		this.ngaysinh.nhap();
		do {
			System.out.println("Nhap so luong hoc phan dang ky: ");
			this.soluonghp = sc.nextInt();
			if(this.soluonghp < 0) {
				System.out.println("khong hop le nhap lai!");
			}
		}while(this.soluonghp <0 || this.soluonghp > 60);// cho tối đa là 60
		sc.nextLine();
		System.out.println("Nhap ten cac hoc phan dang ky: ");
		for(int i = 0; i < this.soluonghp; i++) {
			System.out.println("nhap ten hp thu " + (i + 1) + ":");
			// vì khi khởi tạo điểm thì nó null rr nếu new String từng cái là rỗng
			this.tenhp[i] = sc.nextLine();// khỏi cần new String vì sc lo rr
		}
	}
	
	public void nhapDiem(Scanner sc, int t) {
		for(int i = t; i < this.soluonghp; i++) {
				System.out.println("nhap diem cho mon thu " + ( i + 1) + " | " + this.tenhp[i]);
				this.diemhp[i]= sc.nextLine().toUpperCase();	
		}
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("mssv: ").append(this.mssv)
		.append("\nho ten: ").append(this.hoten)
		.append("\nngay sinh: ").append(this.ngaysinh)
		.append("\nso luong hoc phan dang ky: ").append(this.soluonghp)
		.append("\nten hp va diem: \n");
		for(int i = 0; i < this.soluonghp; i++) {
			result.append(this.tenhp[i]).append(" || ").append(this.diemhp[i] == null? "chua nhap" : this.diemhp[i]).append("\n");
		}
		return result.toString();
	}
	
	public void in() {
		System.out.println(this);
	}
	
	public float doiDiem(String diem) {// tham so String đê so sánh
		if(diem == null || diem.trim().isEmpty()) {// kiểm tra sau gọt có rỗng ko
			return 0f;
		}
		switch (diem.trim().toUpperCase()) {// cần gọt khoảng trắng
        case "A":  return 4.0f;// tự gọi ngầm equal
        case "B+": return 3.5f;
        case "B":  return 3.0f;
        case "C+": return 2.5f;
        case "C":  return 2.0f;
        case "D+": return 1.5f;
        case "D":  return 1.0f;
        case "F":  return 0.0f;
        default:   return 0.0f; // Điểm không hợp lệ cũng trả về 0
    }
	}
	
	
	
	public float diemTrungBinh() {
	    if (this.soluonghp == 0) return 0f;// không có môn nào thì 0 điểm
	    float tb = 0f;
	    for (int i = 0; i < this.soluonghp; i++) {//chạy phạm vi những môn đã đk
	        tb += doiDiem(this.diemhp[i]);
	    }
	    return tb / this.soluonghp;// phải chia lại cho số lượng hp
	}
	
	public void dangKyHP(String tenhp, Scanner sc) {
		if(tenhp.trim().isEmpty() || this.soluonghp == 60) {
			System.out.println(this.soluonghp == 60? "hp day khong the dk them":"vui long nhap ten hp");
		}else {
			this.tenhp[this.soluonghp] = new String(tenhp.trim());
			nhapDiem(sc, this.soluonghp++);
		}
			
	}
	
	public void xoaHP(String tenhp) {
		if(tenhp.trim().isEmpty()) {
			System.out.println("vui long nhap ten hp");
		}else {
			boolean t = false;
			for(int p = 0; p < this.soluonghp; p++) {
				if(tenhp.equalsIgnoreCase(this.tenhp[p].trim())) {
					t = true;
				}
				if(t) {
					this.tenhp[p] = p == this.soluonghp - 1? null : this.tenhp[p+1];
					this.diemhp[p] = p == this.soluonghp - 1? null : this.diemhp[p+1];
				}
			}
			if(!t) {
				System.out.println("khong tim thay!");
			}else {
				this.soluonghp--;// trừ lại
			}
		}
	}
	
	public String layTen() {
		String s = new String(this.hoten);
		if(!this.hoten.trim().isEmpty()) {
			s = s.trim();
			int p = s.lastIndexOf(" ");
			s = s.substring(p+1);
		}
		return s;
	}
	
	public int laySoLuongHP() {
		return this.soluonghp;
	}
	
}
