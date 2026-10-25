package TH_03;
import java.util.Scanner;

import TH_02.Date;
public class SinhVien {
	private String mssv, hoten;
	private Date ngaysinh;
	private int sohpdk;
	private String tenhpdk[], dhp[];
	public SinhVien() {
		this.mssv = new String();
		this.hoten = new String();
		this.ngaysinh = new Date();
		this.sohpdk = 0;
		this.tenhpdk = new String[sohpdk];
		this.dhp = new String[sohpdk];
	}
	
	
	public SinhVien(String mssv, String hoten, Date ngaysinh, int sohpdk, String tenhpdk[], String dhp[]) {
		this.mssv = mssv;
		this.hoten = hoten;
		this.ngaysinh = new Date(ngaysinh);
		this.sohpdk = sohpdk;
		this.tenhpdk = new String[sohpdk];
		this.dhp = new String[sohpdk];
		for(int i = 0; i < sohpdk; i++) {
			this.tenhpdk[i] = tenhpdk[i];
			this.dhp[i] = dhp[i];
			
		}
	}
	
	public SinhVien(SinhVien a) {
		this.mssv = a.mssv;
		this.hoten = a.hoten;
		this.ngaysinh = new Date(a.ngaysinh);
		this.sohpdk = a.sohpdk;
		this.tenhpdk = new String[a.sohpdk];
		System.arraycopy(a, 0, this.tenhpdk, 0, a.sohpdk);
		this.dhp = new String[a.sohpdk];
		System.arraycopy(a, 0, this.dhp, 0, a.sohpdk);
		// dùng array.coppyOf
	}
	
	public String chuanHoa(String input) {
		if(input == null || input.trim().isEmpty()) {
			return "";
		}
		
		String words[] = input.trim().replaceAll("\\s+", " ").toUpperCase().split(" ");
		StringBuilder result = new StringBuilder();
		for(String word : words) {
			if(!word.isEmpty()) {
				result.append(Character.toUpperCase(word.charAt(0)))
				.append(word.substring(1))
				.append(" ");
			}
		}
		return result.toString().trim();
	}
	
	public boolean trungThongTin(String s1, String s2) {
		return s1.equalsIgnoreCase(s2);
	}
	
	public boolean trungThongTin(String t, String s[]) {
		for(String e : s) {
			if(e != null && trungThongTin(t, e)) {
				return true;
			}
		}
		return false;
	}
	public boolean trungMssv(String t, SinhVien s[], int SoSV) {
		for(int i = 0; i < SoSV; i++) {
			if(s[i].mssv != null && trungThongTin(t, s[i].mssv)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean trungTenMon(String t, String s[], int SoMon) {
		for(int i = 0; i < SoMon; i++) {
			if(s[i] != null && trungThongTin(t, s[i])) {
				return true;
			}
		}
		return false;
	}
	
	
	public void nhapCoBan() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap mssv: ");
		this.mssv = sc.nextLine();
		System.out.println("nhap ho ten: ");
		this.hoten = sc.nextLine();
		this.hoten = chuanHoa(hoten);
		System.out.println("nhap ngay sinh: ");
		this.ngaysinh.nhap();
		do {
		System.out.println("nhap so luong hoc phan dang ky: ");
		this.sohpdk = sc.nextInt();
		if(sohpdk <= 0) {
			System.out.println("khong hop le phai lon hon 0 nhap lai!");
		}
		}while(this.sohpdk <= 0);
		sc.nextLine();
		this.tenhpdk = new String[this.sohpdk];
		this.dhp = new String[this.sohpdk];
		for (int i = 0; i < this.sohpdk; i++) {
		    do {
		        System.out.print("Nhap ten hoc phan thu " + (i + 1) + ": ");
		        String tenMoi = chuanHoa(sc.nextLine());
		        
		        if (trungTenMon(tenMoi, this.tenhpdk, i)) { 
		            System.out.println("Ten hoc phan da ton tai, vui long nhap lai!");
		        } else {
		            this.tenhpdk[i] = tenMoi;
		            this.dhp[i] = "";
		            break;
		        }
		    } while (true);
		}
		

		
	}
	
	public boolean diemHopLe(String word) {
		word.trim();
		Character.toLowerCase(word.charAt(0));
		if(word == "a" || word == "b" || word == "c" || word == "d" || word == "f") {
			return true;
		}
		return false;
	}
	
	public void nhapDiem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap diem cho sinh vien " + this.hoten);
		for(int i = 0; i < this.sohpdk; i++) {
			do {
				System.out.println("nhap diem cho hoc phan " + this.tenhpdk[i]);
				this.dhp[i] = sc.nextLine();
				if(!diemHopLe(this.dhp[i])) {
					System.out.println("diem nhap khong hop le nhap lai!");
				}
			}while(!diemHopLe(this.dhp[i]));
			
		}
	}
	
	private float quyDoiDiem(String diem) {
		switch(diem) {
		case "A" : return 4.0f;
		case "B+" : return 3.5f;
		case "B" : return 3.0f;
		case "C+" : return 2.5f;
		case "C" : return 2.0f;
		case "D+" : return 1.5f;
		case "D" : return 1.0f;
		default : return 0.0f;
		}
	}
	
	public float diemTrungBinh() {
		float avg = 0f;
		int dem =0;
		for(int i = 0; i < this.sohpdk; i++) {
			if(this.dhp[i] != null && !this.dhp[i].isEmpty()) {
				dem++;
				avg += quyDoiDiem(this.dhp[i]);
			}
		}
		return dem == 0 ? 0.0f : avg/dem;
	}
	
	public void dangKyThem(String tenHP) {
		do {
			if(!trungThongTin(tenHP, this.tenhpdk)) {
				System.out.println("ban da dang ky hoc phan nay roi nhap hoc phan khac");
				
			}else {
				String newten[] = new String[this.sohpdk + 1];
				String newdiem[] = new String[this.sohpdk + 1];
				for(int i = 0; i < this.sohpdk; i++) {
					newten[i] = this.tenhpdk[i];
					newdiem[i] = this.dhp[i];
				}
				newten[this.sohpdk + 1] = tenHP;
				newdiem[this.sohpdk + 1] ="";
				this.tenhpdk = newten;
				this.dhp = newdiem;
				this.sohpdk++;
				System.out.println("them thanh cong");
			}
			
		}while(!trungThongTin(tenHP, this.tenhpdk));
	}
	
	public void xoaHocPhan(String tenHP) {
		if(trungThongTin(tenHP, this.tenhpdk)) {
			String newten[] = new String[this.sohpdk - 1];
			String newdiem[] = new String[this.sohpdk - 1];
			for(int i = 0; i < this.sohpdk; i++) {
				if(!trungThongTin(tenHP, this.tenhpdk[i])) {
					newten[i] = this.tenhpdk[i];
					newdiem[i] = this.dhp[i];
				}
				
			}
			this.tenhpdk = newten;
			this.dhp = newdiem;
			this.sohpdk--;
			System.out.println("xoa thanh cong");
		}else {
			System.out.println("khong co hoc phan nay de xoa");
		}
	}
	
	public String getTen() {
		return (this.hoten.lastIndexOf(" ") == -1)? this.hoten : this.hoten.substring(this.hoten.lastIndexOf(" ") + 1);
	}
	
	public String getHoTenDem() {
		return this.hoten.substring(0, this.hoten.lastIndexOf(" ") -1);
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("MSSV: ").append(this.mssv)
		.append("\nho ten: ").append(this.hoten)
		.append("\nngay sinh: ").append(ngaysinh)
		.append("\ndiem trung binh: ").append(String.format("%.2f", diemTrungBinh()))
		.append("\n[hoc phan & diem]");
		for(int i = 0; i < this.sohpdk; i++) {
			result.append(this.tenhpdk[i]).append(" (").append(this.dhp[i].isEmpty()? "chua nhap" : this.dhp[i])
			.append(")");
			if(i < this.sohpdk - 1) {
				result.append(", ");
			}
		}
		return result.toString();
		
	}
	
	public void hienThi() {
		System.out.println(this);
	}
	
	
	public String getMssv() {
		return this.mssv;
	}
	public String getHoTen() {
		return this.hoten;
	}
}
