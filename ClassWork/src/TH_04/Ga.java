package TH_04;

public class Ga extends ConVat {
	public Ga() {
		super();
	}
	
	public Ga(String giong, String maulong, float cannang) {
		super(giong, maulong, cannang);
	}
	
	public Ga(Ga t) {
		super(t);
	}
	
	
	@Override
	public void keu() {
		System.out.println("o oo o o o ");
	}
}
