package TH_03_Restar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SDSinhVien {

	public static void main(String[] args) {
		SinhVien a = new SinhVien();
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap thong tin cho sinh vien a");
		a.nhap(sc);
		a.nhapDiem(sc, 0);
		a.dangKyHP("LTHDT", sc);
		System.out.println("thong tin cua sinh vien a la");
		a.in();
		System.out.println("Nhap so sinh vien trong danh sach");
		int n = sc.nextInt();
		sc.nextLine();
		SinhVien ds[] = new SinhVien[n];
		SinhVien max = new SinhVien();
		ArrayList<SinhVien> bicanhbao = new ArrayList<>();// danh sách động tham chiêú sinh viên
		for(int i = 0; i < n; i++) {
			System.out.println("nhap thong tin cho sinh vien thu " + (i + 1) + ": ");
			ds[i] = new SinhVien();
			ds[i].nhap(sc);
			ds[i].nhapDiem(sc, 0);
			float dtb = ds[i].diemTrungBinh();// tránh goị hàm nhiều lần
			if(i == 0) {
				max = ds[i];
			}
			
			if(dtb < 1.0f) {
				bicanhbao.add(new SinhVien(ds[i]));
			}
			
			if(dtb > max.diemTrungBinh()) {
				max = ds[i];
			}
		}
		ArrayList<SinhVien> maxDiem = new ArrayList<>();
		System.out.println("thong tin cua danh sach sinh vien vua nhap la");
		for(SinhVien e:ds) {
			if(e.diemTrungBinh() == max.diemTrungBinh()) {
				maxDiem.add(new SinhVien(e));
			}
			e.in();
		}
		
		System.out.println("cac sinh vien bi canh bao hoc vu");
		if(bicanhbao.isEmpty()) {
			System.out.println("khong co sinh vien nao bi canh bao hoc vu\n");
		}else {
			for(SinhVien e: bicanhbao) {
				e.in();
			}
		}
		
		System.out.println("cac sinh vien co diem trung binh cao nhat");
		for(SinhVien e:maxDiem) {
			e.in();
		}
		
		System.out.println("danh sach theo thu tu alphabet la");
		SinhVien sortSV[] = ds.clone();// cho nhanh
		Arrays.sort(sortSV, 0, n);
		for(SinhVien e:sortSV) {
			e.in();
		}
		sc.close();
	}

}
