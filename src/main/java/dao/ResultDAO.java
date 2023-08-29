package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import homework.JankenBean;

public class ResultDAO {
//	Connection con = null;
//	
//		// データベースに接続
//		con = DriverManager.getConnection(
//				"jdbc:mysql://localhost/java_janken",
//				"root",
//				"kCky6R22");
	private final String JDBC_URL =
			"jdbc:mysql://localhost/java_janken";
	private final String DB_USER = "root";
	private final String DB_PASS = "kCky6R22";
	
	public List<JankenBean>findAll(){
		 List<JankenBean>jankenList= new ArrayList<>();
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
		 }catch(ClassNotFoundException e) {
			 throw new IllegalStateException("JDBCドライバを読み込ませんでした");
		 }
		 try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			 String sql = "SELECT id,myselfname,pcname,result,memo FROM jankenresult ORDER BY id DESC";
//			 System.out.println("データベース接続成功");
			 PreparedStatement pStmt = conn.prepareStatement(sql);
			 ResultSet rs = pStmt.executeQuery();
			 
			 
			 while(rs.next()) {
				 int id = rs.getInt("id");
				 String myselfResultName = rs.getString("myselfname"); 
				 String pcResultName = rs.getString("pcname");
				 String result= rs.getString("result");
				 String memo =rs.getString("memo");
				 JankenBean jankenbean = new JankenBean(myselfResultName,pcResultName,result,memo);
				 jankenList.add(jankenbean);
			 }
		 }catch(SQLException e) {
			 e.printStackTrace();
			 return null;
			 
		 }
		
		return jankenList;
	}
	
	public boolean create(JankenBean jankenbean) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
		 }catch(ClassNotFoundException e) {
			 throw new IllegalStateException("JDBCドライバを読み込ませんでした");
		 }
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
//			System.out.println("データベース接続成功"); 
			String sql = "INSERT INTO jankenresult(myselfname,pcname,result) VALUE(?,?,?)";
			 PreparedStatement pStmt = conn.prepareStatement(sql);
			 pStmt.setString(1,jankenbean.getMyselfResultName());
			 pStmt.setString(2,jankenbean.getPcResultName());
			 pStmt.setString(3,jankenbean.getResult());
			 
			 int re = pStmt.executeUpdate();
			 
			 
			 if (re !=1) {
				 return false;
			 }
			 
		 }catch(SQLException e) {
			 e.printStackTrace();
			 return false;
			 
		 }
		
		return true;
	}
	
	public boolean creatememo(JankenBean jankenbean) {
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 
		 }catch(ClassNotFoundException e) {
			 throw new IllegalStateException("JDBCドライバを読み込ませんでした");
		 }
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
//			System.out.println("データベース接続成功"); 
			String sql = "INSERT INTO jankenresult(memo) VALUE(?)";
			 PreparedStatement pStmt = conn.prepareStatement(sql);
			 pStmt.setString(1,jankenbean.getMemo());
			 
			 int re = pStmt.executeUpdate();			 
			 
			 if (re !=1) {
				 return false;
			 }
			 
		 }catch(SQLException e) {
			 e.printStackTrace();
			 return false;
			 
		 }
		
		return true;
	}
	
	
	

}
