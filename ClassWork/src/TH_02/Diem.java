package TH_02;
import java.util.Scanner;

public class Diem {
    private int x, y;

    public Diem() {
        x = 0;
        y = 0;
    }
    
    public Diem(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Diem(Diem d) {
    	this.x = d.x;
    	this.y = d.y;
    }
    
    public void nhapDiem() {
        Scanner sc = new Scanner(System.in);
        System.out.print("   + Nhập hoành độ x: ");
        this.x = sc.nextInt();
        System.out.print("   + Nhập tung độ y: ");
        this.y = sc.nextInt();
    }
    
    public void hienThi() {
        System.out.println("(" + this.x + ", " + this.y + ")");
    }
    
    public String toString() {
    	return "(" + this.x + ", " + this.y + ")";
    }
    
    public void doiDiem(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int giaTriX() {
        return this.x;
    }
    
    public int giaTriY() {
        return this.y;
    }
    
    public float khoangCach() {
        return (float) Math.sqrt(x * x + y * y);// vì mặc định Math trả về là Double nên cần ép kiểu tường minh
    }
    
    public float khoangCach(Diem d) {
        int dx = this.x - d.x;
        int dy = this.y - d.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }
}