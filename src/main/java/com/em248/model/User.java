package com.em248.model;

public class User {
	private int uid;
	private int ustatus;
	private String uname;
	private String uemail;
	private String upassword;
	private String uimageurl;//头像
	private String ucellphone;
	private String usexy;
	private String uaddress;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getUstatus() {
		return ustatus;
	}

	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUimageurl() {
		return uimageurl;
	}

	public void setUimageurl(String uimageurl) {
		this.uimageurl = uimageurl;
	}

	public String getUcellphone() {
		return ucellphone;
	}

	public void setUcellphone(String ucellphone) {
		this.ucellphone = ucellphone;
	}

	public String getUsexy() {
		return usexy;
	}

	public void setUsexy(String usexy) {
		this.usexy = usexy;
	}

	public String getUaddress() {
		return uaddress;
	}

	public void setUaddress(String uaddress) {
		this.uaddress = uaddress;
	}

	public User(int uid, int ustatus, String uname, String uemail, String upassword, String uimageurl,
			String ucellphone, String usexy, String uaddress) {
		super();
		this.uid = uid;
		this.ustatus = ustatus;
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
		this.uimageurl = uimageurl;
		this.ucellphone = ucellphone;
		this.usexy = usexy;
		this.uaddress = uaddress;
	}

	
	public User(String uname, String upassword) {
		super();
		this.uname = uname;
		this.upassword = upassword;
	}
	
	
	public User(String uname, String uemail, String upassword) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
	}
	

	public User(int uid, String uname, String uemail, String uimageurl, String ucellphone, String usexy,
			String uaddress) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uemail = uemail;
		this.uimageurl = uimageurl;
		this.ucellphone = ucellphone;
		this.usexy = usexy;
		this.uaddress = uaddress;
	}

	public User() {
		super();
	}
	

}
