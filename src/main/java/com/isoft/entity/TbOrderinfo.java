package com.isoft.entity;


import java.io.Serializable;

public class TbOrderinfo  implements Serializable {

  private int id;
  private int goodsId;
  private int num;
  private int orderId;

  public TbOrderinfo() {
  }

  public TbOrderinfo(int id, int goodsId, int num, int orderId) {
    this.id = id;
    this.goodsId = goodsId;
    this.num = num;
    this.orderId = orderId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getGoodsId() {
    return goodsId;
  }

  public void setGoodsId(int goodsId) {
    this.goodsId = goodsId;
  }


  public int getNum() {
    return num;
  }

  public void setNum(int num) {
    this.num = num;
  }


  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
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
