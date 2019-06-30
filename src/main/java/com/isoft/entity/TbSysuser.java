package com.isoft.entity;


import java.io.Serializable;

public class TbSysuser  implements Serializable {

  private long id;
  private String sid;
  private String sname;
  private String spass;
  private String smobile;
  private long state;
  private long srole;

  public TbSysuser() {
  }

  public TbSysuser(long id, String sid, String sname, String spass, String smobile, long state, long srole) {
    this.id = id;
    this.sid = sid;
    this.sname = sname;
    this.spass = spass;
    this.smobile = smobile;
    this.state = state;
    this.srole = srole;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getSid() {
    return sid;
  }

  public void setSid(String sid) {
    this.sid = sid;
  }


  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }


  public String getSpass() {
    return spass;
  }

  public void setSpass(String spass) {
    this.spass = spass;
  }


  public String getSmobile() {
    return smobile;
  }

  public void setSmobile(String smobile) {
    this.smobile = smobile;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }


  public long getSrole() {
    return srole;
  }

  public void setSrole(long srole) {
    this.srole = srole;
  }

  @Override
  public String toString() {
    return "TbSysuser{" +
            "id=" + id +
            ", sid='" + sid + '\'' +
            ", sname='" + sname + '\'' +
            ", spass='" + spass + '\'' +
            ", smobile='" + smobile + '\'' +
            ", state=" + state +
            ", srole=" + srole +
            '}';
  }
}

