package TH_02;

import java.util.Scanner;

public class SDPhanSo {

	public static void main(String[] args) {
		PhanSo a = new PhanSo(3, 7);
		PhanSo b = new PhanSo(4, 9);
		a.hienThi();
		System.out.println(" = " + a.giaTriThuc());
		b.hienThi();
		System.out.println(" = " + b.giaTriThuc());
		PhanSo x = new PhanSo();
		PhanSo y = new PhanSo();
		System.out.println("nhap phan so x: ");
		x.nhap(); 
		System.out.println("nhap phan so y: ");
		y.nhap();
		System.out.println("phan so x y vua nhap la: ");
		System.out.println("nghich dao cua x la: ");
		PhanSo x1 = x.giaTriNghichDao();
		x1.hienThi();
		System.out.print("\nx +  y = ");
		x.cong(y).hienThi();
		Scanner sc = new Scanner(System.in);
		System.out.println("so phan so muon nhap: ");
		int n = sc.nextInt();
		PhanSo ds[] = new PhanSo[n];
		PhanSo dsSort[] = new PhanSo[n];
		PhanSo tong = new PhanSo();
		PhanSo max = new PhanSo();
		for(int i = 0; i < n; i++) {
			System.out.println("nhap phan tu thu " + (i+1) + " : ");
			ds[i] = new PhanSo();
			ds[i].nhap();
			tong.cong(ds[i]);
			if(!max.lonHon(ds[i])) {
				max = ds[i];
			}
			int p = i -1;
			while(p >= 0 && dsSort[p].lonHon(ds[i])) {
				dsSort[p + 1] = dsSort[p];
				p--;
			}
			dsSort[p + 1] = ds[i];
			
		}
		System.out.println("mang vua nhap la: ");
		for(PhanSo e : ds) {
			e.hienThi();
		}
		System.out.print("so lon nhat la: ");
		max.hienThi();
		System.out.println("mang sau khi duoc sap xep la: ");
		for(PhanSo e : dsSort) {
			e.hienThi();
		}
		
		
	}

}
