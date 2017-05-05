package com.em248.model;

import java.sql.Date;

public class Usercomments {
	private int cid;
	private int uid;
	private int pid;
	private String ccontext;
	private Date ctime;
	private int cstatus;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getCcontext() {
		return ccontext;
	}

	public void setCcontext(String ccontext) {
		this.ccontext = ccontext;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public int getCstatus() {
		return cstatus;
	}

	public void setCstatus(int cstatus) {
		this.cstatus = cstatus;
	}

}
