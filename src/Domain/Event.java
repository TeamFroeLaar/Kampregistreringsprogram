package Domain;
 
public class Event
{
	private String id;
	private String event;
	private String holdid;
	private String kampid;
	private String datotid;
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
	public String getDatotid() {
		return datotid;
	}
	public void setDatotid(String datotid) {
		this.datotid = datotid;
	}
}