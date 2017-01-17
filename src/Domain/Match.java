package Domain; 

public class Match 
{
	private String id;
	private String hjemmeholdId;
	private String udeholdId;
	private String datoTid;
	private String hjemmeholdNavn;
	private String udeholdNavn;

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
	public String getHjemmeholdNavn() {
		return hjemmeholdNavn;
	}
	public void setHjemmeholdNavn(String hjemmeholdNavn) {
		this.hjemmeholdNavn = hjemmeholdNavn;
	}
	public String getUdeholdNavn() {
		return udeholdNavn;
	}
	public void setUdeholdNavn(String udeholdNavn) {
		this.udeholdNavn = udeholdNavn;
	}
	@Override
	public String toString() {
		return "Match [id=" + id + ", hjemmeholdId=" + hjemmeholdId + ", udeholdId=" + udeholdId + ", datoTid="
				+ datoTid + ", hjemmeholdNavn=" + hjemmeholdNavn + ", udeholdNavn=" + udeholdNavn + "]";
	}

	
}
