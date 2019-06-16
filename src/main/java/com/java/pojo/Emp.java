package com.java.pojo;

import lombok.Data;

@Data
public class Emp {

  private long empno;
  private String ename;
  private String job;
  private long mgr;
  private java.sql.Date hiredate;
  private double sal;
  private double comm;
  private long deptno;




}
