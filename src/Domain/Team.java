package Domain;

public class Team {
	private String id;
	private String holdnavn;

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
}