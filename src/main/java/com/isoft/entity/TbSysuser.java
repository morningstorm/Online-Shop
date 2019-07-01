package com.isoft.entity;


import java.io.Serializable;

public class TbSysuser  implements Serializable {

  private int id;
  private String sid;
  private String sname;
  private String spass;
  private String smobile;
  private int status;
  private int srole;

  public TbSysuser() {
  }

  public TbSysuser(int id, String sid, String sname,
                   String spass, String smobile, int status,
                   int srole) {
    this.id = id;
    this.sid = sid;
    this.sname = sname;
    this.spass = spass;
    this.smobile = smobile;
    this.status = status;
    this.srole = srole;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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


  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }


  public int getSrole() {
    return srole;
  }

  public void setSrole(int srole) {
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
            ", status=" + status +
            ", srole=" + srole +
            '}';
  }
}

