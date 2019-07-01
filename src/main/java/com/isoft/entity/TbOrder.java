package com.isoft.entity;


import java.io.Serializable;
import java.sql.Timestamp;

public class TbOrder  implements Serializable {

  private int id;
  private String oid;
  private int auserId;
  private double amount;
  private int status;
  private java.sql.Timestamp orderdate;
  private String message;
  private String address;

  public TbOrder() {
  }

  public TbOrder(int id, String oid, int auserId, double amount, int status, Timestamp orderdate, String message, String address) {
    this.id = id;
    this.oid = oid;
    this.auserId = auserId;
    this.amount = amount;
    this.status = status;
    this.orderdate = orderdate;
    this.message = message;
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }


  public int getAuserId() {
    return auserId;
  }

  public void setAuserId(int auserId) {
    this.auserId = auserId;
  }


  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }


  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
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
