package Domain;

public class Team {
	private String id;
	private String holdnavn;
	private int points;
	private int mål;
	private int målImod;
	private int vundne;
	private int tabte;
	private int uafgjorte;
	private int stilling;
	

	public String getId() {
		return id;
	} 

	public void setId(String id) {
		this.id = id;
	}

	public String getHoldnavn() {
		return holdnavn;
	}

	public void setHoldnavn(String holdnavn) {
		this.holdnavn = holdnavn;
	}

	@Override
	public String toString() {
		return holdnavn;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getMål() {
		return mål;
	}

	public void setMål(int mål) {
		this.mål = mål;
	}

	public int getMålImod() {
		return målImod;
	}

	public void setMålImod(int målImod) {
		this.målImod = målImod;
	}

	public int getVundne() {
		return vundne;
	}

	public void setVundne(int vundne) {
		this.vundne = vundne;
	}

	public int getTabte() {
		return tabte;
	}

	public void setTabte(int tabte) {
		this.tabte = tabte;
	}

	public int getUafgjorte() {
		return uafgjorte;
	}

	public void setUafgjorte(int uafgjorte) {
		this.uafgjorte = uafgjorte;
	}

	public int getStilling() {
		return stilling;
	}

	public void setStilling(int stilling) {
		this.stilling = stilling;
	}
	
}