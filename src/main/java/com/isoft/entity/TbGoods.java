package com.isoft.entity;


import java.io.Serializable;

public class TbGoods  implements Serializable {

  private Integer id;
  private String gid;
  private String gname;
  private double gprice;
  private String gpicture;
  private String gmessage;
  private Integer gstatus;
  private Integer typeId;

  public TbGoods() {
  }

  public TbGoods(Integer id, String gid, String gname, double gprice, String gpicture, String gmessage, Integer gstatus, Integer typeId) {
    this.id = id;
    this.gid = gid;
    this.gname = gname;
    this.gprice = gprice;
    this.gpicture = gpicture;
    this.gmessage = gmessage;
    this.gstatus = gstatus;
    this.typeId = typeId;
  }

  public int getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getGid() {
    return gid;
  }

  public void setGid(String gid) {
    this.gid = gid;
  }


  public String getGname() {
    return gname;
  }

  public void setGname(String gname) {
    this.gname = gname;
  }


  public double getGprice() {
    return gprice;
  }

  public void setGprice(double gprice) {
    this.gprice = gprice;
  }


  public String getGpicture() {
    return gpicture;
  }

  public void setGpicture(String gpicture) {
    this.gpicture = gpicture;
  }


  public String getGmessage() {
    return gmessage;
  }

  public void setGmessage(String gmessage) {
    this.gmessage = gmessage;
  }


  public int getGstatus() {
    return gstatus;
  }

  public void setGstatus(Integer gstatus) {
    this.gstatus = gstatus;
  }


  public int getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }

  @Override
  public String toString() {
    return "TbGoods{" +
            "id=" + id +
            ", gid='" + gid + '\'' +
            ", gname='" + gname + '\'' +
            ", gprice=" + gprice +
            ", gpicture='" + gpicture + '\'' +
            ", gmessage='" + gmessage + '\'' +
            ", gstatus=" + gstatus +
            ", typeId=" + typeId +
            '}';
  }
}
