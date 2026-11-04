package TH_04;

public class De extends ConVat{
	public De() {
		super();
	}
	
	public De(String giong, String maulong, float cannang) {
		super(giong, maulong, cannang);
	}
	
	public De(De t) {
		super(t);
	}
	
	
	@Override
	public void keu() {
		System.out.println("CR7 siuuuuuuuuuuuuu!");
	}
}
