package Domain;

public class League {
	private String stilling;
	private String holdnavn;
	private String numberGoals;
	private String win;
	private String loss;
	private String point;
	
	public String getHoldnavn() {
		return holdnavn;
	}
	public void setHoldnavn(String holdnavn) {
		this.holdnavn = holdnavn;
	}
	public String getStilling() {
		return stilling;
	}
	public void setStilling(String stilling) {
		this.stilling = stilling;
	}
	public String getNumberGoals() {
		return numberGoals;
	}
	public void setNumberGoals(String event) {
		this.numberGoals = event;
	}
	public String getWin() {
		return win;
	}
	public void setWin(String win) {
		this.win = win;
	}
	public String getLoss() {
		return loss;
	}
	public void setLoss(String loss) {
		this.loss = loss;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	@Override
	public String toString() {
		return "League [holdnavn=" + holdnavn + ", stilling=" + stilling + ", event=" + numberGoals + ", win=" + win
				+ ", loss=" + loss + ", point=" + point + "]";
	}
	
	
}
