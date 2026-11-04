package TH_04;

public class Bo extends ConVat {
	
	public Bo() {
		super();
	}
	
	public Bo(String giong, String maulong, float cannang) {
		super(giong, maulong, cannang);
	}
	
	public Bo(Bo t) {
		super(t);
	}
	
	
	@Override
	public void keu() {
		System.out.println("um boooooooo!");
	}
}
