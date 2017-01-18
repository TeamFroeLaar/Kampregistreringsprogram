package Domain;

public class League {
	private String holdnavn;
	private String stilling;
	private String event;
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
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
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
		return "League [holdnavn=" + holdnavn + ", stilling=" + stilling + ", event=" + event + ", win=" + win
				+ ", loss=" + loss + ", point=" + point + "]";
	}
	
	
}
