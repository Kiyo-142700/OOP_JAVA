package TH_03;

import java.util.ArrayList;
import java.util.Scanner;

public class SDSinhVien {

	public static void main(String[] args) {
		SinhVien a = new SinhVien();
		a.nhapCoBan();
		a.dangKyThem("LTHDT");
		a.nhapDiem();
		a.hienThi();
		System.out.println("nhap so sinh vien trong danh sach");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		SinhVien ds[] = new SinhVien[n];
		ArrayList<SinhVien> bicanhbao = new ArrayList<>();
		ArrayList<SinhVien> svavgmax = new ArrayList<>();
		SinhVien avgmax = new SinhVien();
		for(int i = 0; i < n; i++) {
			ds[i] = new SinhVien();
			do {
				System.out.println("nhap thong tin sinh vien thu " + (i+1));
				ds[i].nhapCoBan();
				if(ds[i].trungMssv(ds[i].getMssv(), ds, i)) {
					System.out.println("sinh vien nay da nhap roi");
				}
			}while(ds[i].trungMssv(ds[i].getMssv(), ds, i));
			
			ds[i].nhapDiem();
			avgmax = ds[0];
			if(ds[i].diemTrungBinh() > avgmax.diemTrungBinh()) {
				avgmax = new SinhVien(ds[i]);
			}
			if(ds[i].diemTrungBinh() <= 2.0) {
				bicanhbao.add(new SinhVien(ds[i]));
			}
		}
		System.out.println("danh sach sinh vien vua nhap");
		for(SinhVien e:ds) {
			if(e.diemTrungBinh() == avgmax.diemTrungBinh()) {
				svavgmax.add(new SinhVien(e));
			}
			e.hienThi();
			System.out.println();
		}
		System.out.println("cac sinh vien bi canh bao hoc vu");
		for(SinhVien e:bicanhbao) {
			e.hienThi();
		}
		System.out.println("sinh vien co diem trung binh cao nhat");
		for(SinhVien e:svavgmax) {
			e.hienThi();
		}
		
		
	}

}
