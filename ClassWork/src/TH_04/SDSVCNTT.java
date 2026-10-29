package TH_04;

import java.util.Scanner;

public class SDSVCNTT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong sinh vien trong danh sach: ");
		int n = sc.nextInt();
		sc.nextLine();
		SinhVienCNTT ds[] = new SinhVienCNTT[n];
		for(int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin cho sinh vien thu " + (i + 1) + ": ");
			ds[i] = new SinhVienCNTT();
			ds[i].nhapSVCNTT(sc);
		}
		System.out.println("Thong tin " + n + " sinh vien CNTT vua nhap la");
		for(SinhVienCNTT e: ds) {
			e.hienThi();
			System.out.println();
		}
		
		System.out.println("\n===================================================\n");
		String email;
		do {
			System.out.print("Nhap dia chi email muon tim: ");
			email = sc.nextLine();
			if(email.trim().isEmpty()) {
				System.out.println("Khong hop le nhap lai!");
			}
		}while(email.trim().isEmpty());
		
		boolean t = false;
		System.out.println("Ket qua hoc tap cua sinh vien CNTT co e mail (" + email + ") la");
		for(SinhVienCNTT e:ds) {
			t = e.getEmail().equalsIgnoreCase(email);
			if(t) {
				e.hienThi();
				break;
			}
		}
		if(!t) {
			System.out.println("Khong co sinh vien nao co email " + email);
		}
		
		
	}

}
