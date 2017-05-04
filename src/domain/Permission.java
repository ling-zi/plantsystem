package domain;

public class Permission {
	private int pmsid;
	private String pmsname;
	private String pmsdesc;
	private String pmsurl;
	private int pmsstatus;

	public int getPmsid() {
		return pmsid;
	}

	public void setPmsid(int pmsid) {
		this.pmsid = pmsid;
	}

	public String getPmsname() {
		return pmsname;
	}

	public void setPmsname(String pmsname) {
		this.pmsname = pmsname;
	}

	public String getPmsdesc() {
		return pmsdesc;
	}

	public void setPmsdesc(String pmsdesc) {
		this.pmsdesc = pmsdesc;
	}

	public String getPmsurl() {
		return pmsurl;
	}

	public void setPmsurl(String pmsurl) {
		this.pmsurl = pmsurl;
	}

	public int getPmsstatus() {
		return pmsstatus;
	}

	public void setPmsstatus(int pmsstatus) {
		this.pmsstatus = pmsstatus;
	}

}
