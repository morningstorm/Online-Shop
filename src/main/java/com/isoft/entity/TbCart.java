package com.isoft.entity;


import java.io.Serializable;

public class TbCart  implements Serializable {

  private int id;
  private int auserId;
  private int goodsId;


  public TbCart() {
  }

  public TbCart(int id, int auserId, int goodsId) {
    this.id = id;
    this.auserId = auserId;
    this.goodsId = goodsId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getAuserId() {
    return auserId;
  }

  public void setAuserId(int auserId) {
    this.auserId = auserId;
  }


  public int getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(int goodsId) {
    this.goodsId = goodsId;
  }

  @Override
  public String toString() {
    return "TbCart{" +
            "id=" + id +
            ", auserId=" + auserId +
            ", goodsId=" + goodsId +
            '}';
  }
}
