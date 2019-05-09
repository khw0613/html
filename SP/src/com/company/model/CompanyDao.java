package com.company.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.company.model.CompanyVO;

public class CompanyDao {
   String driver = "oracle.jdbc.driver.OracleDriver";
   String url = "jdbc:oracle:thin:@localhost:1521:xe";
   String user = "patagonia";
   String password = "q1w2e3r4";

   public CompanyVO select(CompanyVO vo) throws Exception {
      // 하나의 값만 가져오므로 select
      String query = "";

      query += "select ";
      query += "   co_id, ";
      query += "   co_name, ";
      query += "   manager_id, ";
      query += "   stock_yn, ";
      query += "   co_tel, ";
      query += "   co_ceo_name, ";
      query += "   intime , ";
      query += "   inid, ";
      query += "   uptime, ";
      query += "   upid ";
      query += "from ";
      query += "    company ";

      query += " where ";
      query += " co_id='" + vo.getCo_id() + "' ";

      Class.forName(driver); // 드라이버클래스 로딩
      Connection conn = DriverManager.getConnection(url, user, password); Statement stmt = conn.createStatement(); // SQL 문을 나타내는 객체
      ResultSet rs = stmt.executeQuery(query);

      CompanyVO resultvo = new CompanyVO();
      while (rs.next()) {
         String co_id = rs.getString(1);
         String co_name = rs.getString(2);
         String manager_id = rs.getString(3);
         String stock_yn = rs.getString(4);
         String co_tel = rs.getString(5);

         String co_ceo_name = rs.getString(6);
         String intime = rs.getString(7);
         String inid = rs.getString(8);
         String uptime = rs.getString(9);
         String upid = rs.getString(10);

         resultvo.setCo_id(co_id); // 셋팅
         resultvo.setCo_name(co_name);
         resultvo.setManager_id(manager_id);
         resultvo.setStock_yn(stock_yn);
         resultvo.setCo_tel(co_tel);

         resultvo.setCo_ceo_name(co_ceo_name);
         resultvo.setIntime(intime);
         resultvo.setInid(inid);
         resultvo.setUptime(uptime);
         resultvo.setUpid(upid);

      }

      rs.close();
      stmt.close();
      conn.close();

      return resultvo;
   }

   public ArrayList<CompanyVO> selectlist(CompanyVO vo) throws Exception {
      String query = "";

      query += "select ";
      query += "   co_id, ";
      query += "   co_name, ";
      query += "   manager_id, ";
      query += "   stock_yn, ";
      query += "   co_tel, ";
      query += "   co_ceo_name, ";
      query += "   intime, ";
      query += "   inid, ";
      query += "   uptime, ";
      query += "   upid ";
      query += "from ";
      query += "    company ";

      ArrayList<CompanyVO> compList = new ArrayList<CompanyVO>();

      Class.forName(driver); // 드라이버클래스 로딩
      Connection conn = DriverManager.getConnection(url, user, password);   Statement stmt = conn.createStatement(); // SQL 문을 나타내는 객체
      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {
         String co_id = rs.getString(1);
         String co_name = rs.getString(2);
         String manager_id = rs.getString(3);
         String stock_yn = rs.getString(4);
         String co_tel = rs.getString(5);

         String co_ceo_name = rs.getString(6);
         String intime = rs.getString(7);
         String inid = rs.getString(8);
         String uptime = rs.getString(9);
         String upid = rs.getString(10);

         CompanyVO tempvo = new CompanyVO();
         tempvo.setCo_id(co_id); // 셋팅
         tempvo.setCo_name(co_name);
         tempvo.setManager_id(manager_id);
         tempvo.setStock_yn(stock_yn);
         tempvo.setCo_tel(co_tel);

         tempvo.setCo_ceo_name(co_ceo_name);
         tempvo.setIntime(intime);
         tempvo.setInid(inid);
         tempvo.setUptime(uptime);
         tempvo.setUpid(upid);
         compList.add(tempvo);

      }

      rs.close();
      stmt.close();
      conn.close();

      return compList;
   }

   public int insert(CompanyVO vo) throws Exception {
      String query = "";
      query += "insert into company ";
      query += "( ";
      query += "   co_id, ";
      query += "   co_name, ";
      query += "   manager_id, ";
      query += "   stock_yn, ";
      query += "   co_tel, ";
      query += "   co_ceo_name, ";
      query += "   intime, ";
      query += "   inid, ";
      query += "   uptime, ";
      query += "   upid ";
      query += ") ";
      query += "values ";
      query += "( ";
      query += " '" + vo.getCo_id() + "', ";
      query += " '" + vo.getCo_name() + "', ";
      query += " '"+ vo.getManager_id() + "', "; 
      query += " '"+ vo.getStock_yn() + "', ";
      query += " '"+ vo.getCo_tel() + "', ";
      
      query += " '" + vo.getCo_ceo_name() + "', ";
      query +="sysdate, ";
      query += " '" + vo.getManager_id() + "', ";
      query +="sysdate, ";
      query += "'" + vo.getManager_id()+"' ";
      query += ") ";

      Class.forName(driver);
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stmt = con.createStatement();
      int cnt = stmt.executeUpdate(query);

      stmt.close();
      con.close();
      return cnt;
   }

   public int update(CompanyVO vo) throws Exception {
      String query = "";
      query += " update company ";
      query += " set ";
      query += " co_id='" + vo.getCo_id() + "', ";
      query += " co_name='" + vo.getCo_name() + "', ";
      query += " manager_id='" + vo.getManager_id() + "', ";
      query += " stock_yn='" + vo.getStock_yn() + "', ";
      query += " co_tel='" + vo.getCo_tel() + "', ";

      query += " co_ceo_name='" + vo.getCo_ceo_name() + "', ";
      query += " uptime=sysdate,  ";
      query += " upid='" + vo.getManager_id() + "' ";

      query += " where ";
      query += " co_id='" + vo.getCo_id() + "' ";

      Class.forName(driver);
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stmt = con.createStatement();
      int cnt = stmt.executeUpdate(query);

      stmt.close();
      con.close();
      return cnt;
   }

   public int delete(CompanyVO vo) throws Exception {
      String query = "";
      query += "delete from company ";
      query += "where ";
      query += "co_id= ' " + vo.getCo_id() + " '";

      Class.forName(driver);
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stmt = con.createStatement();
      int cnt = stmt.executeUpdate(query);

      stmt.close();
      con.close();
      return cnt;
   }

   public static void main(String[] args) throws Exception {
      CompanyDao dao = new CompanyDao();
      ArrayList<CompanyVO> list = dao.selectlist(null);

      for (int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i).getCo_id()
               + list.get(i).getCo_name() + list.get(i).getManager_id()
               + list.get(i).getStock_yn() + list.get(i).getCo_tel()
               + list.get(i).getCo_ceo_name() + list.get(i).getIntime()
               + list.get(i).getInid() + list.get(i).getUptime()
               + list.get(i).getUpid());
      }

      //insert
      /*  CompanyVO vo = new CompanyVO(); 
        vo.setCo_id("11"); // 사번
        vo.setCo_name("4"); // 이름
        vo.setManager_id("4");
        vo.setStock_yn("4");
        vo.setCo_tel("4"); 
        
        vo.setCo_ceo_name("4");
        vo.setIntime("1");
        vo.setInid("4");
        vo.setUptime("12");
        vo.setUpid("4");
        
        int cnt = dao.insert(vo);
        System.out.println(cnt + "개 적용되었습니다.");*/
      
	   //update
	  /* CompanyVO vo = new CompanyVO(); 
       vo.setCo_id("11"); // 사번
       vo.setCo_name("2"); // 이름
       vo.setManager_id("2");
       vo.setStock_yn("2");
       vo.setCo_tel("2"); 
       
       vo.setCo_ceo_name("2");
       vo.setIntime("2");
       vo.setInid("2");
       vo.setUptime("2");
       vo.setUpid("2");
       
       int cnt = dao.update(vo);
       System.out.println(cnt + "개 적용되었습니다.");*/
      
      
/*	   CompanyVO vo = new CompanyVO();
	   vo.setCo_id("11");
	   CompanyVO rvo = dao.select(vo);
	   System.out.println(rvo.getCo_ceo_name());*/
      
       CompanyVO vo = new CompanyVO();
	   vo.setCo_id("11");
       
	   int cnt = dao.delete(vo);
       System.out.println(cnt + "개 적용되었습니다.");
      
     
      
      /*
       * CompanyVO vo = new CompanyVO(); // update vo.setCo_id("4"); // 사번
       * vo.setCo_name("4"); // 이름 vo.setManager_id("4"); vo.setStock_yn("4");
       * 
       * vo.setCo_tel("4"); vo.setCo_ceo_name("4"); vo.setInid("4");
       * vo.setUpid("633");
       * 
       * int cnt = dao.update(vo); System.out.println(cnt + "개 적용되었습니다.");
       */

   /*   CompanyVO vo = new CompanyVO(); // delete
      vo.setCo_id("4"); // 사번

      int cnt = dao.delete(vo);
      System.out.println(cnt + "개 삭제되었습니다.");*/
   }
}