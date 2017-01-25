package Domain;
 
public class Event
{
	private String id;
	private String event;
	private String holdid;
	private String kampid;
	private String tid;
	private String holdnavn;
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getHoldid() {
		return holdid;
	}
	public void setHoldid(String holdid) {
		this.holdid = holdid;
	}
	public String getKampid() {
		return kampid;
	}
	public void setKampid(String kampid) {
		this.kampid = kampid;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getHoldnavn() {
		return holdnavn;
	}
	public void setHoldnavn(String holdnavn) {
		this.holdnavn = holdnavn;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", event=" + event + ", holdid=" + holdid + ", kampid=" + kampid + ", tid=" + tid
				+ ", holdnavn=" + holdnavn + "]";
	}

}
