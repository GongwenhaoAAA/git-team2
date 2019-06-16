package com.java.dao.impl;

import com.java.pojo.Dept;
import com.java.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class empImpl {
    private SqlSession session=null;
    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sql=new SqlSessionFactoryBuilder();
        InputStream ins = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory build = sql.build(ins);
        session = build.openSession();
    }
    @Test
    public  void selectAll() throws IOException {
      List<Emp>  lists=session.selectList("com.java.dao.impl.empImpl.selectAll");
        lists.forEach(v-> System.out.println(v));

    }

   @Test
    public void selectOne() throws IOException {
        Map<String,Object> mp=new HashMap<>();
        mp.put("ename","张");
        List<Map<String,Object>>  one= session.selectList("com.java.dao.impl.empImpl.selectOne", mp);
        one.forEach(k-> System.out.println(k));
     }
  @Test
  public void insert(){
      /*Map<String,Object> map=new HashMap<>();
      map.put("deptno",90);
      map.put("dname","人大");
      map.put("loc","中央");*/
      Dept dept=new Dept(90,"土星","土星总部");
      int i = session.insert("com.java.dao.impl.empImpl.insert", dept);
      System.out.println(i);
  }
  @Test
  public void update(){
      /*Map<String,Object> map=new HashMap<>();
      map.put("deptno",90);
      map.put("dname","哈哈哈");
      map.put("loc","哈哈哈");*/
      Dept dept=new Dept(90,"火星","火星总部");
      int i = session.update("com.java.dao.impl.empImpl.update", dept);
      System.out.println(i);
  }
  @Test
  public void delete(){
      int deptno=90;
      int i = session.delete("com.java.dao.impl.empImpl.delete", deptno);
      System.out.println(i);
  }
    @Test
  public void selectEmp(){
        List<Emp>  lists=session.selectList("com.java.dao.impl.empImpl.selectEmp");
        lists.forEach(v-> System.out.println(v));
  }
     @After
     public void destroy(){
       session.commit();
     }
}
