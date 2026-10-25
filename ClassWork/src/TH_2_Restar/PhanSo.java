package TH_2_Restar;

import java.util.Scanner;

public class PhanSo {
	private int tu, mau;
	
	public PhanSo() {
		this.tu = 0;
		this.mau = 1;
	}
	
	public PhanSo(int tu, int mau) {
		this.tu = tu;
		this.mau = mau;
	}
	
	public PhanSo(PhanSo a) {
		this.tu = a.tu;
		this.mau = a.mau;
	}
	
	public void nhap() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("nhap tu so");
			this.tu = sc.nextInt();
			System.out.println("nhap mau so");
			this.mau = sc.nextInt();
			if(this.mau == 0) {
				System.out.println("khong hop le! mau phai khac 0. nhap lai");
			}
		}while(this.mau == 0);
	}
	
	public void chuanHoa() {
	    int a = Math.abs(this.tu);
	    int b = Math.abs(this.mau);//không cần tìm sô lớn hơn vì vòng lặp đầu tiên sẽ đổi vị trí số lớn vs nhỏ
	    while (b != 0) {
	        int r = a % b;
	        a = b;
	        b = r;
	    }
	    this.tu /= a;
	    this.mau /= a;
	    if (this.mau < 0) {
	        this.mau = -this.mau;
	        this.tu = -this.tu;
	    }
	}
	
	public void hienThi() {
		this.chuanHoa();
		System.out.printf( this.tu == 0 ? "0" : this.mau == 1? this.tu +"" : this.tu + " / " + this.mau);
	}
	
	public String toString() {
		this.chuanHoa();
		return this.tu == 0 ? "0" : this.mau == 1? this.tu +"" : this.tu + " / " + this.mau;
	}
	
	public void nghichDao() {
	    if (this.tu != 0) {//tranh trường hợp nghịch đảo 0/1 thành 1/0 -> ko hợp lệ
	        int temp = this.tu;
	        this.tu = this.mau;
	        this.mau = temp;
	    } else {
	        System.out.println("Khong the nghich dao phan so co tu = 0");
	    }
	}
	
	public PhanSo giaTriNghichDao() {
		PhanSo t = new PhanSo(this.tu, this.mau);
		t.nghichDao();
		return t;
	}
	
	public float giaTriThuc() {
		return (float)this.tu / this.mau;
	}
	
	public boolean lonHon(PhanSo a) {
		return this.giaTriThuc() > a.giaTriThuc();// nó tự hiểu vì trả về boolean
	}
	
	public PhanSo cong(PhanSo a) {
	    PhanSo kq = new PhanSo();
	    kq.tu = this.tu * a.mau + a.tu * this.mau;//tạo kq rr nhân trực tiếp không nên sửa đổi giá trị vào vi phạm obj
	    kq.mau = this.mau * a.mau;
	    kq.chuanHoa();
	    return kq;
	}
	
	public PhanSo tru(PhanSo a) {
	    PhanSo kq = new PhanSo();
	    kq.tu = this.tu * a.mau - a.tu * this.mau;
	    kq.mau = this.mau * a.mau;
	    kq.chuanHoa();
	    return kq;
	}
	
	public PhanSo nhan(PhanSo a) {
		PhanSo nhan = new PhanSo(this.tu, this.mau);
		nhan.tu *= a.tu;
		nhan.mau *= a.mau;
		nhan.chuanHoa();
		return nhan;
	}
	
	public PhanSo chia(PhanSo a) {
		PhanSo chia = new PhanSo(this.tu, this.mau);
		PhanSo nghichdaocuaA = a.giaTriNghichDao();
		chia = chia.nhan(nghichdaocuaA);
		return chia;
		
	}
	
	public PhanSo cong(int a) {
		PhanSo cong = new PhanSo(this.tu, this.mau);
		PhanSo A = new PhanSo(a, 1);
		cong = cong.cong(A);
		return cong;
	}
	
	public PhanSo tru(int a) {
		PhanSo tru = new PhanSo(this.tu, this.mau);
		PhanSo A = new PhanSo(a, 1);
		tru = tru.tru(A);
		return tru;
	}
	
	public PhanSo nhan(int a) {
		PhanSo nhan = new PhanSo(this.tu, this.mau);
		nhan.tu *= a;
		nhan.chuanHoa();
		return nhan;
	}
	
	public PhanSo chia(int a) {
		PhanSo chia = new PhanSo(this.tu, this.mau);
		chia.mau *= a;
		chia.chuanHoa();
		return chia;
	}
	
	
	
	
	
	
}
