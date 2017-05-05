package com.em248.model;

public class Plant {
	private int pid;
	private String pname;
	private String pphotos;
	private String pdesc;
	private String pfamily;//科
	private String pgenus;//属
	private String phylum;//门

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPphotos() {
		return pphotos;
	}

	public void setPphotos(String pphotos) {
		this.pphotos = pphotos;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public String getPfamily() {
		return pfamily;
	}

	public void setPfamily(String pfamily) {
		this.pfamily = pfamily;
	}

	public String getPgenus() {
		return pgenus;
	}

	public void setPgenus(String pgenus) {
		this.pgenus = pgenus;
	}
	
	public String getPhylum() {
		return phylum;
	}

	public void setPhylum(String phylum) {
		this.phylum = phylum;
	}



	public Plant(int pid, String pname, String pphotos, String pdesc, String pfamily, String pgenus, String phylum) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pphotos = pphotos;
		this.pdesc = pdesc;
		this.pfamily = pfamily;
		this.pgenus = pgenus;
		this.phylum = phylum;
	}

	public Plant(String pname, String pdesc, String pfamily, String pgenus, String phylum) {
		super();
		this.pname = pname;
		this.pdesc = pdesc;
		this.pfamily = pfamily;
		this.pgenus = pgenus;
		this.phylum = phylum;
	}
	

	public Plant(String pname, String pphotos, String pdesc, String pfamily, String pgenus, String phylum) {
		super();
		this.pname = pname;
		this.pphotos = pphotos;
		this.pdesc = pdesc;
		this.pfamily = pfamily;
		this.pgenus = pgenus;
		this.phylum = phylum;
	}

	public Plant() {
		super();
	}

	
}
