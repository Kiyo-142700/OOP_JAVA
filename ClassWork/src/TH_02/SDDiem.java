package TH_02;

public class SDDiem {
    public static void main(String args[]) {
        Diem A = new Diem(3, 4);
        System.out.print("1. Tọa độ điểm A: ");
        A.hienThi();
        Diem B = new Diem();
        System.out.println("2. Nhập tọa độ cho điểm B:");
        B.nhapDiem();
        System.out.print("   -> Tọa độ điểm B vừa nhập: ");
        B.hienThi();
        Diem C = new Diem(-B.giaTriX(), -B.giaTriY());
        System.out.print("3. Tọa độ điểm C (đối xứng với B qua O): ");
        C.hienThi();
        float kcBO = B.khoangCach();
        System.out.println("4. Khoảng cách từ điểm B đến tâm O: " + kcBO);
        float kcAB = A.khoangCach(B);
        System.out.print("5. Khoảng cách từ điểm ");
        A.hienThi();
        System.out.print(" đến điểm ");
        B.hienThi();
        System.out.println("   -> Kết quả: " + kcAB);
    }
}