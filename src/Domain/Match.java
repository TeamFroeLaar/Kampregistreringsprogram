package Domain; 

public class Match 
{
	@Override
	public String toString() {
		return "Match [id=" + id + ", hjemmeholdId=" + hjemmeholdId + ", udeholdId=" + udeholdId + ", datoTid="
				+ datoTid + "]";
	}
	private String id;
	private String hjemmeholdId;
	private String udeholdId;
	private String datoTid;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHjemmeholdId() {
		return hjemmeholdId;
	}
	public void setHjemmeholdId(String hjemmeholdId) {
		this.hjemmeholdId = hjemmeholdId;
	}
	public String getUdeholdId() {
		return udeholdId;
	}
	public void setUdeholdId(String udeholdId) {
		this.udeholdId = udeholdId;
	}
	public String getDatoTid() {
		return datoTid;
	}
	public void setDatoTid(String datoTid) {
		this.datoTid = datoTid;
	}


}
