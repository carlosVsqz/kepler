package com.escod.kepler.data;

public class ResponseException {
  private int status;
  private String detail;

  public ResponseException() {
  }

  public ResponseException(int status, String detail) {
    this.status = status;
    this.detail = detail;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
