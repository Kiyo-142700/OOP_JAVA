package TH_03;

import java.util.Scanner;

public class Gach {
    private String ms;
    private String mau;
    private int soLuong;
    private int chieuDai;
    private int chieuNgang;
    private long giaBan;

    // Constructors
    public Gach() {
        ms = ""; mau = "";
        soLuong = 1; chieuDai = 1; chieuNgang = 1;
        giaBan = 1;
    }

    public Gach(String ms, String mau, int soLuong, int chieuDai, int chieuNgang, long giaBan) {
        this.ms = ms; this.mau = mau;
        this.soLuong = soLuong;
        this.chieuDai = chieuDai; this.chieuNgang = chieuNgang;
        this.giaBan = giaBan;
    }

    public Gach(Gach g) {
        this.ms = g.ms; this.mau = g.mau;
        this.soLuong = g.soLuong;
        this.chieuDai = g.chieuDai; this.chieuNgang = g.chieuNgang;
        this.giaBan = g.giaBan;
    }

    // Hàm phụ trợ nhập số dương
    private int kiemSoNguyen(Scanner sc, String thongBao) {
        int val;
        do {
            System.out.print("Nhap " + thongBao + " (> 0): ");
            val = sc.nextInt();
        } while (val <= 0);
        return val;
    }

    private long kiemSoLong(Scanner sc, String thongBao) {
        long val;
        do {
            System.out.print("Nhap " + thongBao + " (> 0): ");
            val = sc.nextLong();
        } while (val <= 0);
        return val;
    }

    // Hàm nhập thông tin
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma so: "); ms = sc.nextLine();
        System.out.print("Nhap mau: "); mau = sc.nextLine();
        
        soLuong = kiemSoNguyen(sc, "so luong vien trong 1 hop");
        chieuDai = kiemSoNguyen(sc, "chieu dai gach (cm)");
        chieuNgang = kiemSoNguyen(sc, "chieu ngang gach (cm)");
        giaBan = kiemSoLong(sc, "gia ban 1 hop");
    }

    public void nhap(String thongBao) {
        System.out.println(thongBao);
        nhap();
    }

    // toString() & hienThi()
    @Override
    public String toString() {
        return "Ma so: " + ms + " | Mau: " + mau + 
               " | So luong/hop: " + soLuong + 
               " | Kich thuoc: " + chieuDai + "x" + chieuNgang + " cm" +
               " | Gia ban: " + giaBan + " VND";
    }

    public void hienThi() {
        System.out.println(this);
    }

    public void hienThi(String thongBao) {
        System.out.print(thongBao);
        hienThi();
    }

    // Tính giá bán lẻ 1 viên
    public float giaBanLe() {
        return (float) (giaBan * 1.2 / soLuong);
    }

    // Diện tích tối đa 1 hộp (cm2)
    public long dienTichMax() {
        return (long) chieuDai * chieuNgang * soLuong;
    }

    // Số hộp ít nhất khi MUA NGUYÊN HỘP (Không xoay gạch)
    public int soLuongHop(int D, int N) {
        int sd = (D % chieuDai == 0) ? (D / chieuDai) : (D / chieuDai + 1);
        int sn = (N % chieuNgang == 0) ? (N / chieuNgang) : (N / chieuNgang + 1);
        int tongVien = sd * sn;

        return (tongVien % soLuong == 0) ? (tongVien / soLuong) : (tongVien / soLuong + 1);
    }

    // Các Getters cần thiết
    public long getGiaBan() { return giaBan; }
    public String getMs() { return ms; }
    public int getChieuDai() { return chieuDai; }
    public int getChieuNgang() { return chieuNgang; }
    public int getSoLuong() { return soLuong; }
}