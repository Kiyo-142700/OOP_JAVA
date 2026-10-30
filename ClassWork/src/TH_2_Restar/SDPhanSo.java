package TH_2_Restar;

import java.util.Scanner;

public class SDPhanSo {

	public static void main(String[] args) {
		PhanSo a = new PhanSo(3, 7);
		float a1 = a.giaTriThuc();
		PhanSo b = new PhanSo(4,9);
		float b1 = b.giaTriThuc();
		System.out.println("phan so a: " + a);
		System.out.println("gia tri thuc la: " + a1);
		System.out.println("phan so b: " + b);
		System.out.println("gia tri thuc la: " + b1);
		PhanSo x = new PhanSo();
		PhanSo y = new PhanSo();
		System.out.println("nhap phap so x");
		x.nhap();
		System.out.println("nhap phap so y");
		y.nhap();
		float x1 = x.giaTriThuc();
		float y1 = y.giaTriThuc();
		System.out.println("phan so x vua nhap la: " + x + " co gia tri thuc la: " + x1);
		System.out.println("phan so y vua nhap la: " + y + " co gia tri thuc la: " + y1);
		PhanSo x0 = x.giaTriNghichDao();
		System.out.println("gia tri nghich sao cua x la: " + x0);
		PhanSo congXY = x.cong(y);
		float congXY1 = congXY.giaTriThuc();
		System.out.println("tong cua x + y la: " + congXY + " cos gia tri thuc la: " + congXY1);
		PhanSo tong = new PhanSo();
		System.out.println("nhap so phan so muon nhap");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PhanSo max = new PhanSo();
		PhanSo sapxep[] = new PhanSo[n];
		PhanSo ds[] = new PhanSo[n];
		for(int i = 0; i < n; i++) {
			System.out.println("Nhap phan so thu " + (i + 1) + ":");
			ds[i] = new PhanSo();
			ds[i].nhap();
			if(i == 0) {
				max = ds[i];
			}
			if(ds[i].lonHon(max)) {
				max = ds[i];
			}
			tong = tong.cong(ds[i]);
			int p = i -1; //vì số mới nhập khi vào so sánh nó ss vs số trước đó
				while(p >= 0 && sapxep[p].lonHon(ds[i])) {
					sapxep[p + 1] = sapxep[p];
					p--;
				}
				sapxep[p + 1] = new PhanSo(ds[i]);
			
		}
		System.out.println("tong n phan so la: " + tong);
		float giatri = tong.giaTriThuc();
		System.out.println("gia tri thuc cua no la: " + giatri);
		System.out.println("phan so lon nhat la: " + max);
		float max1 = max.giaTriThuc();
		System.out.println("gia tri thuc la: " + max1);
		System.out.println("danh sach truoc khi sap xep la: ");
		for(PhanSo e : ds) {
			System.out.print(e + " | ");
		}
		System.out.println();
		System.out.println("danh sach sau khi sap xep la: ");
		for(PhanSo e : sapxep) {
			System.out.print(e + " | ");
		}
		
	}

}
