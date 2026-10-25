package TH_02;

import java.util.Scanner;

public class PhanSo {
	int tuso, mauso;
	public PhanSo() {
		this.tuso = 0;
		this.mauso = 1;
	}
	
	public PhanSo(int tu, int mau) {
		this.tuso = tu;
		this.mauso = mau;
	}
	public void chuanHoa() {
		int r, a, b;
		a = Math.abs(this.tuso);
		b = Math.abs(this.mauso);
		if( a < b) {
			r = a;
			 a = b;
			 b = r;
		}
		while(b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		this.tuso /= a;
		this.mauso /= a;
		
	}
	
	public void hienThi() {
		if(this.tuso == 0) {
			System.out.println("0");
		}else if(this.mauso == 1){
			System.out.println(this.tuso);
		}else {
			PhanSo t = new PhanSo(this.tuso, this.mauso);
			t.chuanHoa();
			System.out.println(this.tuso + " / " + this.mauso);
			
		}
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.print("nhap tu so: ");
			this.tuso = sc.nextInt();
			System.out.print("nhap mau so");
			this.mauso = sc.nextInt();
			if(this.mauso == 0) {
				System.out.println("khong hop le vui long nhap mau so khac 0!");
			}
		}while(this.mauso == 0);
	}
	public void nghichDao() {
		int temp = this.tuso;
		this.tuso = this.mauso;
		this.mauso = temp;
	}
	
	public PhanSo giaTriNghichDao() {
		PhanSo t = new PhanSo(this.tuso, this.mauso);
		t.nghichDao();
		return t;
	}
	
	public double giaTriThuc() {
		return (double) this.tuso / this.mauso;
	}
	public boolean lonHon(PhanSo a) {
		PhanSo b = new PhanSo(this.tuso, this.mauso);
		return a.giaTriThuc() < b.giaTriThuc() ? true : false;
	}
	
	public PhanSo cong(PhanSo a) {
		PhanSo t = new PhanSo(this.tuso, this.mauso);
		if(t.mauso == a.mauso){
			t.tuso += a.tuso;
		}else {
			t.tuso = t.tuso * a.mauso + a.tuso * t.mauso;
			t.mauso *= a.mauso;
		}
		t.chuanHoa();
		return t;
	}
	public PhanSo tru(PhanSo a) {
		PhanSo t = new PhanSo(this.tuso, this.mauso);
		t.tuso = -t.tuso;
		return t.cong(a);
	}
	
	public PhanSo nhan(PhanSo a) {
		PhanSo t = new PhanSo(this.tuso, this.mauso);
		t.tuso *= a.tuso;
		t.mauso *= a.mauso;
		t.chuanHoa();
		return t;
	}
	
	public PhanSo chia(PhanSo a) {
		PhanSo t = new PhanSo(this.tuso, this.mauso);
		a.nghichDao();
		return t.nhan(a);
	}
	
	public PhanSo congNguyen(int a) {
		PhanSo t = new PhanSo(this.tuso, this.mauso);
		PhanSo a1 = new PhanSo(a, 1);
		return t.cong(a1);
	}
	
	public PhanSo truNguyen(int a) {
		PhanSo t = new PhanSo(this.tuso, this.mauso);
		PhanSo a1 = new PhanSo(a, 1);
		return t.tru(a1);
	}
	
	public PhanSo nhanNguyen(int a) {
		PhanSo t = new PhanSo(this.tuso, this.mauso);
		PhanSo a1 = new PhanSo(a, 1);
		return t.nhan(a1);
		
	}
	
	public PhanSo chiaNguyen(int a) {
		PhanSo t = new PhanSo(this.tuso, this.mauso);
		PhanSo a1 = new PhanSo(a, 1);
		return t.chia(a1);
	}
	
	
}
