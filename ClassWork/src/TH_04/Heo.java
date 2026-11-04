package TH_04;

public class Heo extends ConVat{
	public Heo() {
		super();
	}
	
	public Heo(String giong, String maulong, float cannang) {
		super(giong, maulong, cannang);
	}
	
	public Heo(Heo t) {
		super(t);
	}
	
	
	@Override
	public void keu() {
		System.out.println("mec siiiii ");
	}
}
