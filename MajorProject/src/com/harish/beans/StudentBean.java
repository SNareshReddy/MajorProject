package com.harish.beans;



public class StudentBean {
	private int id;
	private String sname,sfname,smname,address,email,password,cgpa,category,branch,section;
	private long mobile,wnumber,fmobile,mmobile,aadhar;
  
	
	public StudentBean(int id, String sname, String sfname, String smname, String address, long mobile,long wnumber,long fmobile,long mmobile, String email, String password,long aadhar,String cgpa,String category,String branch,String section) {
		super();
		this.id = id;
		this.sname = sname;
		this.sfname=sfname;
		this.smname=smname;
		this.address=address;
		this.mobile=mobile;
		this.wnumber=wnumber;
		this.fmobile=fmobile;
	    this.mmobile=mmobile;
		this.email = email;
		this.password = password;
	    this.aadhar=aadhar;
	    this.cgpa=cgpa;
	    this.category=category;
	    this.branch=branch;
	    this.section=section;
	 
	}
	public StudentBean(String sname, String sfname, String smname, String address, long mobile,long wnumber, long fmobile, long mmobile,String email, String password, long aadhar,String cgpa,String category,String branch,String section) {
		super();
		this.sname = sname;
		this.sfname = sfname;
		this.smname = smname;
		this.address = address;
		this.mobile=mobile;
		this.wnumber=wnumber;
		this.fmobile=fmobile;
		this.mmobile = mmobile;
		this.email = email;
		this.password = password;
		this.aadhar=aadhar;
		this.cgpa=cgpa;
		this.category=category;
		this.branch=branch;
		this.section=section;
	}


	public StudentBean() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return sname;
	}
	public void setName(String sname) {
		this.sname = sname;
	}
	public String getSfname() {
		return sfname;
	}
	public void setSfname(String sfname) {
		this.sfname = sfname;
	}
	
	public String getSmname() {
		return smname;
	}
	public void setSmname(String smname) {
		this.smname = smname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
        this.address = address;
	}

	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public long getWnumber(){
		return wnumber;
	}
	public void setWnumber(long wnumber){
		this.wnumber=wnumber;
	}
    public long getFmobile() {
		return fmobile;
	}
	public void setFmobile(long fmobile) {
		this.fmobile = fmobile;
	}
	public long getMmobile() {
		return mmobile;
	}
	public void setMmobile(long mmobile) {
		this.mmobile = mmobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public String getCgpa() {
		return cgpa;
	}
	public void setCgpa(String cgpa) {
		this.cgpa = cgpa;
	}
	public String getCategory(){
		return category;
	}
	public void setCategory(String category){
		this.category=category;
	}
    public String getBranch(){
    	return branch;
    }
    public void setBranch(String branch){
    	this.branch=branch;
    }
    public String getSection(){
    	return section;
    }
    public void setSection(String section){
    	this.section=section;
    }

	}