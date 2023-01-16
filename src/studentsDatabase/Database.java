package studentsDatabase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Database {
	

	static Connection dbConn=null;
	static Vector rowInfo1=new Vector();
	static Vector columnAtrs1=new Vector();
	static Vector rowInfo2=new Vector();
	static Vector rowInfo3=new Vector();
	static Vector columnAtrs2=new Vector();
	static Vector columnAtrs3=new Vector();
	static JTable table1 = null;
	static JTable table2 = null;
	static JTable table3 = null;
	JScrollPane scrollpane = null;
	static ArrayList   data  =   new   ArrayList();
	
	static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static String DB_URL = "jdbc:mysql://localhost:3306/studentsmanager?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	static String userName = "root"; 
	static String userPwd = "123456"; 

	public static void openDB(){//连接数据库
		try {
			Class.forName(JDBC_DRIVER);
		    dbConn = DriverManager.getConnection(DB_URL, userName, userPwd);//注册驱动并获得连接
			if(dbConn.isClosed())
				System.out.println("数据库已关闭！");
			else
				System.out.println("连接成功！");   
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insert_student(String s1,String s2,String s3,String s4){//插入学生信息
		openDB();
		try {
		String sql="insert into student values('" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "')";
		Statement statement = dbConn.createStatement();//数据库操作的对象
		int a = statement.executeUpdate(sql);
		
		if (a == 1) {
			JOptionPane.showMessageDialog(null, "插入成功", "成功", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "插入失败", "失败", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public static void insert_score(int student_id,int course_id,int score){
		openDB();
		String sql="insert into score values("+student_id+","+course_id+","+score+")";
		Statement statement;
		try {
			statement = dbConn.createStatement();
			int a = statement.executeUpdate(sql);
			
			if(a==1){
				JOptionPane.showMessageDialog(null, "插入成功", "成功", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "插入失败", "失败", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public static void delete(int studentId) throws SQLException{
		openDB();
		Statement stmt =null;
		try {
			dbConn.setAutoCommit(false);//将SQL语句的提交（commit）由驱动程序转交给应用程序负责,程序必须调用commit或者rollback方法回滚
			stmt = dbConn.createStatement();
			String sql1="delete from score where student_id="+studentId;
			String sql2="delete from student where student_id="+studentId;
			int b=stmt.executeUpdate(sql1);
			int a=stmt.executeUpdate(sql2);
			dbConn.commit();  // 提交JDBC事务
			dbConn.setAutoCommit(true);// 恢复JDBC事务的默认提交方式
			if (a!=0) //删除学生和成绩
			{
				JOptionPane.showMessageDialog(null, "删除成功", "成功", JOptionPane.INFORMATION_MESSAGE);
			}
			else//若学生不存在，删除失败
			{
				JOptionPane.showMessageDialog(null, "学生不存在，删除失败", "失败", JOptionPane.INFORMATION_MESSAGE);
			}
			stmt.close();
			} 
		catch (Exception e) {
			//若SQL语句执行异常，删除失败
			JOptionPane.showMessageDialog(null, "删除失败", "失败", JOptionPane.INFORMATION_MESSAGE);
			dbConn.rollback();// 回滚JDBC事务
			e.printStackTrace();
			stmt.close();
		}
		closeDB();
	}
	
	public static void update_student(int a,String b) throws SQLException {
		openDB();
		CallableStatement callableStatement;
		callableStatement = dbConn.prepareCall("{call update_student (?,?)}");
		callableStatement.setInt(1, a);
		callableStatement.setString(2, b);
		
		int c=callableStatement.executeUpdate();
		if(c==1){
			JOptionPane.showMessageDialog(null, "更新成功", "成功", JOptionPane.INFORMATION_MESSAGE);
		}
		 else {
			JOptionPane.showMessageDialog(null, "更新失败", "失败", JOptionPane.INFORMATION_MESSAGE);
		}
		closeDB();
	}
	
	public static void update_score(int a,int b,int c) throws SQLException {
		openDB();
		CallableStatement callableStatement;
		callableStatement = dbConn.prepareCall("{call update_score (?,?,?)}");
		callableStatement.setInt(1, a);
		callableStatement.setInt(2, b);
		callableStatement.setInt(3, c);
		
		int d=callableStatement.executeUpdate();
		if(d==1){
			JOptionPane.showMessageDialog(null, "更新成功", "成功", JOptionPane.INFORMATION_MESSAGE);
		}
		 else {
			JOptionPane.showMessageDialog(null, "更新失败", "失败", JOptionPane.INFORMATION_MESSAGE);
		}
		closeDB();
	}
	
	public static void select_student_score(String id) throws SQLException{
		openDB();
		ResultSet rs=null;
		Statement statement=null;
		columnAtrs1.add("学号");
		columnAtrs1.add("课程");
		columnAtrs1.add("成绩");
		table1 = new JTable(null, columnAtrs1);

		String sql="select * from scoreview where student_id="+id+";";
		statement = dbConn.createStatement();
		rs = statement.executeQuery(sql);
		Vector v=new Vector();
		v.add("学号");
		v.add("课程名");
		v.add("成绩");
		rowInfo1.add(v);
		Integer i=1;
		while (rs.next()){
			int student_id=rs.getInt("student_id");
			String course_name=rs.getString("course_name");
			int score=rs.getInt("score");
			Vector data=new Vector();
			data.add(student_id);
			data.add(course_name);
			data.add(score);
			rowInfo1.add(data);	
			i++;
		}
		if (rs != null) {
			rs.close();
			rs = null;
		}	
		closeDB();
		table1=new JTable(rowInfo1,columnAtrs1);
		table1.setRowHeight(30);
		table1.setBounds(80,120,400,30*i);
	}
	
	public static void select_dept(String name) throws SQLException{
		openDB();
		ResultSet rs=null;
		Statement statement=null;
		columnAtrs2.add("学号");
		columnAtrs2.add("姓名");
		table2 = new JTable(null, columnAtrs2);

		String sql="select * from studentview where student_dept='"+name+"';";
		statement = dbConn.createStatement();
		rs = statement.executeQuery(sql);
		Vector v=new Vector();
		v.add("学号");
		v.add("姓名");
		rowInfo2.add(v);
		Integer i=1;
		while (rs.next()){
			int student_id=rs.getInt("student_id");
			String student_name=rs.getString("student_name");
			Vector data=new Vector();
			data.add(student_id);
			data.add(student_name);
			rowInfo2.add(data);	
			i++;
		}
		if (rs != null) {
			rs.close();
			rs = null;
		}	
		closeDB();
		table2=new JTable(rowInfo2,columnAtrs2);
		table2.setRowHeight(25);
		table2.setBounds(80,100,400,25*i);
	}
	
	public static void select_score(String id) throws SQLException{
		openDB();
		ResultSet rs=null;
		Statement statement=null;
		columnAtrs3.add("学号");
		columnAtrs3.add("姓名");
		columnAtrs3.add("成绩");
		table3 = new JTable(null, columnAtrs3);
		String sql="select * from scoreview,courseview where course_id="+id+" and courseview.course_name=scoreview.course_name;";
		statement = dbConn.createStatement();
		rs = statement.executeQuery(sql);
		Vector v=new Vector();
		v.add("学号");
		v.add("姓名");
		v.add("成绩");
		rowInfo3.add(v);
		Integer i=1;
		while (rs.next()){
			int student_id=rs.getInt("student_id");
			int score=rs.getInt("score");
			String student_name=rs.getString("student_name");
			Vector data=new Vector();
			data.add(student_id);
			data.add(student_name);
			data.add(score);
			rowInfo3.add(data);	
			i++;
		}
		if (rs != null) {
			rs.close();
			rs = null;
		}	
		closeDB();
		table3=new JTable(rowInfo3,columnAtrs3);
		table3.setRowHeight(25);
		table3.setBounds(80,150,400,25*i);
	}
	
	public static void select_student(String id) throws SQLException{
		openDB();
		ResultSet rs=null;
		Statement statement=null;
		
		String sql="select * from studentview where student_id="+id+";";
		statement = dbConn.createStatement();
		rs = statement.executeQuery(sql);

		while (rs.next()){
			int student_id=rs.getInt("student_id");
			String student_name=rs.getString("student_name");
			String student_sex=rs.getString("student_sex");
			String student_dept=rs.getString("student_dept");			

			data.add(student_id);
			data.add(student_name);
			data.add(student_sex);
			data.add(student_dept);
		}
		if (rs != null) {
			rs.close();
			rs = null;
		}
		closeDB();
	}
	
	public static void closeDB() {
		try {
			dbConn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public  Database() throws SQLException {
//		
//	}
//	public static void main(String[] args) throws SQLException {
//		new Database();
//	}
}
