package com.isoft.entity;


import java.io.Serializable;

public class TbCart  implements Serializable {

  private long id;
  private long auserId;
  private long goodsId;


  public TbCart() {
  }

  public TbCart(long id, long auserId, long goodsId) {
    this.id = id;
    this.auserId = auserId;
    this.goodsId = goodsId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getAuserId() {
    return auserId;
  }

  public void setAuserId(long auserId) {
    this.auserId = auserId;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
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
