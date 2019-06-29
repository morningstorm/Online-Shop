package com.isoft.entity;


import java.io.Serializable;

public class TbOrderinfo  implements Serializable {

  private long id;
  private long goodsId;
  private long num;
  private long orderId;

  public TbOrderinfo() {
  }

  public TbOrderinfo(long id, long goodsId, long num, long orderId) {
    this.id = id;
    this.goodsId = goodsId;
    this.num = num;
    this.orderId = orderId;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(long goodsId) {
    this.goodsId = goodsId;
  }


  public long getNum() {
    return num;
  }

  public void setNum(long num) {
    this.num = num;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }

  @Override
  public String toString() {
    return "TbOrderinfo{" +
            "id=" + id +
            ", goodsId=" + goodsId +
            ", num=" + num +
            ", orderId=" + orderId +
            '}';
  }
}
