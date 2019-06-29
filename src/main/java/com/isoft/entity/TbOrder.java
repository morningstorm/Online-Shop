package com.isoft.entity;


import java.io.Serializable;
import java.sql.Timestamp;

public class TbOrder  implements Serializable {

  private long id;
  private String oid;
  private long auserId;
  private double amount;
  private long status;
  private java.sql.Timestamp orderdate;
  private String message;
  private String address;

  public TbOrder() {
  }

  public TbOrder(long id, String oid, long auserId, double amount, long status, Timestamp orderdate, String message, String address) {
    this.id = id;
    this.oid = oid;
    this.auserId = auserId;
    this.amount = amount;
    this.status = status;
    this.orderdate = orderdate;
    this.message = message;
    this.address = address;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }


  public long getAuserId() {
    return auserId;
  }

  public void setAuserId(long auserId) {
    this.auserId = auserId;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public java.sql.Timestamp getOrderdate() {
    return orderdate;
  }

  public void setOrderdate(java.sql.Timestamp orderdate) {
    this.orderdate = orderdate;
  }


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "TbOrder{" +
            "id=" + id +
            ", oid='" + oid + '\'' +
            ", auserId=" + auserId +
            ", amount=" + amount +
            ", status=" + status +
            ", orderdate=" + orderdate +
            ", message='" + message + '\'' +
            ", address='" + address + '\'' +
            '}';
  }
}
