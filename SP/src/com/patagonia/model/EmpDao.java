package com.patagonia.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.patagonia.model.EmpVO;

public class EmpDao {
   String driver = "oracle.jdbc.driver.OracleDriver";
   String url = "jdbc:oracle:thin:@localhost:1521:xe";
   String user = "patagonia";
   String password = "q1w2e3r4";

   public EmpVO ddong(EmpVO vo) throws Exception {
      // select * from --- 에서 *은 잘사용하지 않는다
      String query = "";

      query += "select ";
      query += "   sawon_id, ";
      query += "   sawon_name, ";
      query += "   mobile, ";
      query += "   email, ";
      query += "   ins_date, ";
      query += "   ins_id, ";
      query += "   upd_date, ";
      query += "   upd_id ";
      query += "from ";
      query += "    emp ";

      query += " where ";
      query += " sawon_id='"+vo.getSawon_id()+"' ";

      Class.forName(driver); // 드라이버클래스 로딩
      Connection conn = DriverManager.getConnection(url, user, password); // DB연결된
      // 상태(세션)을
      // 담은 객체
      Statement stmt = conn.createStatement(); // SQL 문을 나타내는 객체
      ResultSet rs = stmt.executeQuery(query);


      EmpVO resultVO = new EmpVO();
      while (rs.next()) {
         String sawon_id = rs.getString(1);
         String sawon_name = rs.getString(2);
         String mobile = rs.getString(3);
         String email = rs.getString(4);

         String ins_date = rs.getString(5);
         String ins_id = rs.getString(6);
         String upd_date = rs.getString(7);
         String upd_id = rs.getString(8);

         resultVO.setSawon_id(sawon_id);   //셋팅
         resultVO.setSawon_name(sawon_name);
         resultVO.setMobile(mobile);
         resultVO.setEmail(email);

         resultVO.setIns_date(ins_date);
         resultVO.setIns_id(ins_id);
         resultVO.setUpd_date(upd_date);
         resultVO.setUpd_id(upd_id);

      }

      // Connection, Statement, ResultSet은 사용한후 항상 닫아야함(메모리가 남을 가능성이 있기때문에
      // 계속누적되면 언젠간죽음)
      // 매트리스개념 스택구조로 오픈했을때와 반대 순서로 닫아줘야함(원래 각각 트라이캐치를 적용해줘야 하는데 교육입장-야매)
      rs.close();
      stmt.close();
      conn.close();

      return resultVO;
   }
   
   
   public ArrayList<EmpVO> selEmp(EmpVO vo) throws Exception {
      // select * from --- 에서 *은 잘사용하지 않는다
      String query = "";

      query += "select ";
      query += "   sawon_id, ";
      query += "   sawon_name, ";
      query += "   mobile, ";
      query += "   email, ";
      query += "   ins_date, ";
      query += "   ins_id, ";
      query += "   upd_date, ";
      query += "   upd_id ";
      query += "from ";
      query += "    emp ";

      ArrayList<EmpVO> empList = new ArrayList<EmpVO>();

      Class.forName(driver); // 드라이버클래스 로딩
      Connection conn = DriverManager.getConnection(url, user, password); // DB연결된
      // 상태(세션)을
      // 담은 객체
      Statement stmt = conn.createStatement(); // SQL 문을 나타내는 객체
      ResultSet rs = stmt.executeQuery(query);

      while (rs.next()) {
         String sawon_id = rs.getString(1);
         String sawon_name = rs.getString(2);
         String mobile = rs.getString(3);
         String email = rs.getString(4);

         String ins_date = rs.getString(5);
         String ins_id = rs.getString(6);
         String upd_date = rs.getString(7);
         String upd_id = rs.getString(8);

         EmpVO tempvo = new EmpVO();
         tempvo.setSawon_id(sawon_id);
         tempvo.setSawon_name(sawon_name);
         tempvo.setMobile(mobile);
         tempvo.setEmail(email);

         tempvo.setIns_date(ins_date);
         tempvo.setIns_id(ins_id);
         tempvo.setUpd_date(upd_date);
         tempvo.setUpd_id(upd_id);

         empList.add(tempvo);

      }

      // Connection, Statement, ResultSet은 사용한후 항상 닫아야함(메모리가 남을 가능성이 있기때문에
      // 계속누적되면 언젠간죽음)
      // 매트리스개념 스택구조로 오픈했을때와 반대 순서로 닫아줘야함(원래 각각 트라이캐치를 적용해줘야 하는데 교육입장-야매)
      rs.close();
      stmt.close();
      conn.close();

      return empList;
   }

   public int insEmp(EmpVO vo) throws Exception {
      String query = "";
         query += "insert into emp ";
         query += "( ";
         query += "sawon_id, sawon_name, mobile, email, ";
         query += "ins_date, ins_id, upd_date, upd_id ";
         query += ") ";
         query += "values ";
         query += "( ";
         query += "'"+vo.getSawon_id()+"', '"+vo.getSawon_name()+"', '"+vo.getMobile()+"', '"+vo.getEmail()+"', ";
         query += "sysdate, '"+vo.getSawon_id()+"', sysdate, '"+vo.getSawon_id()+"' ";
         query += ") ";
      
      
      /*String query = "insert into emp values('" + vo.getSawon_id() + "','"
            + vo.getSawon_name() + "','" + vo.getMobile() + "','"
            + vo.getEmail() + "','" + vo.getIns_date() + "','"
            + vo.getIns_id() + "','" + vo.getUpd_date() + "','"
            + vo.getUpd_id() + "')";*/

      Class.forName(driver);
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stmt = con.createStatement(); // requst
      int cnt = stmt.executeUpdate(query);

      stmt.close();
      con.close();
      return cnt;
   }

   public int updEmp(EmpVO vo) throws Exception {
      String query = "";
      //좋은소스
      query +="update emp ";
      query +="set ";
      query +=" sawon_name='"+vo.getSawon_name()+"', ";
      query +=" mobile='"+vo.getMobile()+"', ";
      query +=" email='"+vo.getEmail()+"', ";
      
      query +="upd_date=sysdate,  ";
      query +="upd_id='"+vo.getSawon_id()+"' ";
      query +="where ";
      query +="sawon_id='"+vo.getSawon_id()+"' ";
      

      Class.forName(driver);
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stmt = con.createStatement();
      int cnt = stmt.executeUpdate(query);

      stmt.close();
      con.close();
      return cnt;
   }

   public int delEmp(EmpVO vo) throws Exception {
      String query = "";
      query += "delete from emp ";
      query += "where ";
      query += "sawon_id= ' "+ vo.getSawon_id()+ " '";

      Class.forName(driver);
      Connection con = DriverManager.getConnection(url, user, password);
      Statement stmt = con.createStatement();
      int cnt = stmt.executeUpdate(query);

      stmt.close();
      con.close();
      return cnt;
   }

   public static void main(String[] args) throws Exception {
      EmpDao dao = new EmpDao();
      ArrayList<EmpVO> list = dao.selEmp(null); // select

      for (int i = 0; i < list.size(); i++) {
         System.out.println(list.get(i).getSawon_id()
               + list.get(i).getSawon_name() + list.get(i).getMobile()
               + list.get(i).getEmail() + list.get(i).getIns_date()
               + list.get(i).getIns_id() + list.get(i).getUpd_date()
               + list.get(i).getUpd_id());
      }

//      EmpVO vo = new EmpVO(); // insert
//      vo.setSawon_id("4"); // 사번
//      vo.setSawon_name("4"); // 이름
//      vo.setMobile("4"); 
//      vo.setEmail("4"); 
//      
//      vo.setIns_id("4");
//      vo.setUpd_id("4"); 
//      
      
//      int cnt = dao.insEmp(vo);
//      System.out.println(cnt + "개 적용되었습니다.");
      
//      EmpVO vo = new EmpVO(); // update
//      vo.setSawon_id("4"); // 사번
//      vo.setSawon_name("7"); // 이름
//      vo.setMobile("7"); 
//      vo.setEmail("7"); 
//      
//      vo.setIns_id("7");
//      vo.setUpd_id("7"); 
//      
//      int cnt = dao.updEmp(vo);
//      System.out.println(cnt + "개 적용되었습니다.");
      
      EmpVO vo = new EmpVO(); // delete
      vo.setSawon_id("4"); // 사번
   
      int cnt = dao.delEmp(vo);
      System.out.println(cnt + "개 삭제되었습니다.");
   }

}