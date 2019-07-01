package com.isoft.entity;


import java.io.Serializable;

public class TbType  implements Serializable {

  private int id;
  private String lbname;

  public TbType() {
  }

  public TbType(int id, String lbname) {
    this.id = id;
    this.lbname = lbname;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getLbname() {
    return lbname;
  }

  public void setLbname(String lbname) {
    this.lbname = lbname;
  }

  @Override
  public String toString() {
    return "TbType{" +
            "id=" + id +
            ", lbname='" + lbname + '\'' +
            '}';
  }
}
