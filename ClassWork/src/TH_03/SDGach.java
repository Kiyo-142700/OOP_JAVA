package TH_03;

import java.util.Scanner;

public class SDGach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so loai gach n: ");
        int n = sc.nextInt();

        Gach[] ds = new Gach[n];
        Gach gachReNhat = null;

        // 1. Nhập danh sách VÀ Tìm gạch rẻ nhất ngay trong lúc nhập
        for (int i = 0; i < n; i++) {
            ds[i] = new Gach();
            ds[i].nhap("\n--- Nhap thong tin loai gach thu " + (i + 1) + " ---");

            if (i == 0 || (double) ds[i].getGiaBan() / ds[i].dienTichMax() < (double) gachReNhat.getGiaBan() / gachReNhat.dienTichMax()) {
                gachReNhat = ds[i];
            }
        }

        // 2. Hiển thị thông tin danh sách gạch
        System.out.println("\n================ DANH SACH GACH VUA NHAP ================");
        for (Gach e : ds) {
            e.hienThi();
        }

        // 3. Hiển thị loại gạch chi phí thấp nhất
        gachReNhat.hienThi("\n================ LOAI GACH CHI PHI THAP NHAT ================\n");

        int D = 2000, N = 500; // 20m x 5m = 2000cm x 500cm

        // 4. TRƯỜNG HỢP 1: KHÔNG ĐƯỢC MUA LẺ GẠCH (PHẢI MUA NGUYÊN HỘP)
        System.out.println("\n======== CHI PHI LOT NEN (5m x 20m) - MUA NGUYÊN HỘP ========");
        for (Gach e : ds) {
            int soHop = e.soLuongHop(D, N);
            long chiPhi = soHop * e.getGiaBan();

            System.out.println("Ma gach: " + e.getMs() + 
                               " | So hop can mua: " + soHop + 
                               " | Tong chi phi: " + chiPhi + " VND");
        }

        // 5. TRƯỜNG HỢP 2: ĐƯỢC MUA LẺ GẠCH (MUA NGUYÊN HỘP + VIÊN LẺ)
        System.out.println("\n======== CHI PHI LOT NEN (5m x 20m) - ĐƯỢC MUA LẺ GẠCH ========");
        for (Gach e : ds) {
            // Tính tổng số viên gạch cần lót (không xoay gạch)
            int sd = (D % e.getChieuDai() == 0) ? (D / e.getChieuDai()) : (D / e.getChieuDai() + 1);
            int sn = (N % e.getChieuNgang() == 0) ? (N / e.getChieuNgang()) : (N / e.getChieuNgang() + 1);
            int tongVien = sd * sn;

            // Bóc tách ra bao nhiêu hộp nguyên và bao nhiêu viên lẻ
            int soHopNguyen = tongVien / e.getSoLuong();
            int soVienLe = tongVien % e.getSoLuong();

            double chiPhiLe = (soHopNguyen * e.getGiaBan()) + (soVienLe * e.giaBanLe());

            long chiPhiIn = (long) chiPhiLe; // Hoặc Math.round(chiPhiLe);
            System.out.println("Ma gach: " + e.getMs() + 
                               " | Hop nguyen: " + soHopNguyen + 
                               " | Vien le: " + soVienLe + 
                               " | Tong chi phi: " + chiPhiIn + " VND");
            // Kết quả in ra: 18384000 VND
        }
    }
}