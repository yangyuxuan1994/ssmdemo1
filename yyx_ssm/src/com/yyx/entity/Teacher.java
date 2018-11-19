package com.yyx.entity;

public class Teacher {
    private Integer id;

    private String tname;

    private Integer cid;
    
    private College college;
    
    

    public College getCollege() {
		return college;
	}

	public void setCollege(College college) {
		this.college = college;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname == null ? null : tname.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}