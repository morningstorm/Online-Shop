package com.isoft.entity;


import java.io.Serializable;
import java.sql.Date;

public class TbUser implements Serializable {

  private long id;
  private String uid;
  private String uname;
  private String upass;
  private String usex;
  private String umobile;
  private String uaddress;
  private String uemail;
  private java.sql.Date birthday;
  private String upicture;
  private long state;

  public TbUser() {
  }

  public TbUser(long id, String uid, String uname,
                String upass, String usex, String umobile,
                String uaddress, String uemail, Date birthday,
                String upicture, long state) {
    this.id = id;
    this.uid = uid;
    this.uname = uname;
    this.upass = upass;
    this.usex = usex;
    this.umobile = umobile;
    this.uaddress = uaddress;
    this.uemail = uemail;
    this.birthday = birthday;
    this.upicture = upicture;
    this.state = state;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }


  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }


  public String getUpass() {
    return upass;
  }

  public void setUpass(String upass) {
    this.upass = upass;
  }


  public String getUsex() {
    return usex;
  }

  public void setUsex(String usex) {
    this.usex = usex;
  }


  public String getUmobile() {
    return umobile;
  }

  public void setUmobile(String umobile) {
    this.umobile = umobile;
  }


  public String getUaddress() {
    return uaddress;
  }

  public void setUaddress(String uaddress) {
    this.uaddress = uaddress;
  }


  public String getUemail() {
    return uemail;
  }

  public void setUemail(String uemail) {
    this.uemail = uemail;
  }


  public java.sql.Date getBirthday() {
    return birthday;
  }

  public void setBirthday(java.sql.Date birthday) {
    this.birthday = birthday;
  }


  public String getUpicture() {
    return upicture;
  }

  public void setUpicture(String upicture) {
    this.upicture = upicture;
  }


  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "TbUser{" +
            "id=" + id +
            ", uid='" + uid + '\'' +
            ", uname='" + uname + '\'' +
            ", upass='" + upass + '\'' +
            ", usex='" + usex + '\'' +
            ", umobile='" + umobile + '\'' +
            ", uaddress='" + uaddress + '\'' +
            ", uemail='" + uemail + '\'' +
            ", birthday=" + birthday +
            ", upicture='" + upicture + '\'' +
            ", state=" + state +
            '}';
  }
}
