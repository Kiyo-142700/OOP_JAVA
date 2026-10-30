package TH_03_Restar;

import java.util.Scanner;

public class SDGach {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhap so luong mau gach: ");
		int n = sc.nextInt();
		sc.nextLine(); // xóa enter
		Gach ds[] = new Gach[n];
		Gach min = new Gach();
		for(int i = 0; i < n; i++) {
			System.out.println("Nhap thong tin loai gach thu " + (i + 1) + ": ");
			ds[i] = new Gach();
			ds[i].nhap(sc);
			if(i == 0) {
				min = ds[i];
			}
			if(ds[i].chiPhi() < min.chiPhi()) {
				min = ds[i];
			}
		}
		
		System.out.println("Thong tin cac loai gach vua nhap la\n");
		for(Gach e:ds) {
			e.in();
		}
		
		System.out.println("Gach co chi phi thap nhat la\n\n" + min);
		
		System.out.println("Chi phi mua gach khi lot nen ngang 5m dai 20m cua tung loai gach (neu khong duoc mua le) la\n");
		long giaban;
		for(Gach e:ds) {
			giaban = e.soLuongHop(2000, 500) * e.getGiaBan();
			e.in();
			System.out.println("chi phi: " + giaban);
		}
		
		System.out.println("Chi phi mua gach khi lot nen ngang 5m dai 20m cua tung loai gach (neu duoc mua le) la");
		double gia;
		for(Gach e:ds) {
			gia = e.soluonggach(2000, 500) * e.giaBanLe();
			e.in();
			System.out.format("chi phi: %.2f" ,gia);
		}
		
		
		sc.close();
	}

}
