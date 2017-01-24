package Domain;

public class Team {
	private String id;
	private String holdnavn;
	private int points;
	

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
}