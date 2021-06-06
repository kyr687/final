package proj.dao;

import java.util.ArrayList;

import proj.vo.*;
import proj.dao.ProjDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProjDAO {
	private static ProjDAO dao = new ProjDAO();
	private ProjDAO() {}

	public static ProjDAO getInstance() {
		// TODO Auto-generated method stub
		return dao;
	}
	
	public Connection connect()
	{
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/final","root","root11");
		}catch(Exception e) {
			System.out.print("MDAO:connect"+e);
		}
		return conn;
	}
	
	public void close(Connection conn, PreparedStatement pstmt)
	{
		if(pstmt != null)
		{
			try {
				pstmt.close();	
			}catch(Exception e){
				System.out.print("Pstmt close error"+e);
			}
		}
		if(conn != null)
		{
			try {
				conn.close();	
			}catch(Exception e){
				System.out.print("Conn close error"+e);
			}
		}
	}
	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
	{
		if(rs != null)
		{
			try {
				rs.close();	
			}catch(Exception e){
				System.out.print("rs close error"+e);
			}
		}
		close(conn,pstmt);
	}
	
	public boolean proflogin(String id, String pwd) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from prof where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result= true;
			}else
				result = false;
			
		}catch(Exception e) {
			System.out.print("login error"+e);
		}finally {
			close(conn,pstmt,rs);
		}
		return result;
	}
	
	public boolean login(String id, String pwd) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from student where id = ? and pwd = ?;");
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				result= true;
			}else
				result = false;
			
		}catch(Exception e) {
			System.out.print("login error"+e);
		}finally {
			close(conn,pstmt,rs);
		}
		return result;
	}

	public boolean search(String id) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select id,name from subject where id=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				result = true;
			}
		}catch(Exception e) {
			System.out.print("error"+e);
		}finally {
			close(conn,pstmt,rs);
		}
		return result;
	}
	
	public ArrayList<Enroll> enlist(){
		ArrayList<Enroll> list = new ArrayList<Enroll>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Enroll enroll = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from enroll");
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				enroll = new Enroll();
				enroll.setStudent(rs.getString(1));
				enroll.setSubject(rs.getString(2));
				list.add(enroll);
			}
		}catch(Exception e) {
			System.out.print("error"+e);
		}finally {
			close(conn,pstmt,rs);
		}
		return list;
		
	}

	public Object enroll(String sid, String id, String name) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try 
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into enroll values(?,?);");
			pstmt.setString(1, sid);
			pstmt.setString(2, Student.getId());
		}catch(Exception e) {
			System.out.print("error"+e);
		}finally {
			close(conn,pstmt);
		}
		return sid;
	}


	public void profenroll(Subject subject) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?,?,?,?);");
			pstmt.setString(1, subject.getId());
			pstmt.setString(2, subject.getName());
			pstmt.setString(3, subject.getCount()+"");
			pstmt.setString(4, subject.getProf());
			pstmt.executeUpdate();
		}catch(Exception e) {
			System.out.print("enroll error"+e);
		}finally {
			close(conn,pstmt);
		}
		
		
	}

	public ArrayList<Student> profstu() {
		// TODO Auto-generated method stub
		ArrayList<Student> list = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Student student = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from Student where id=? and name =?;");
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				student = new Student();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				list.add(student);
			}
		}catch(Exception e) {
			System.out.print("error"+e);
		}finally {
			close(conn,pstmt,rs);
		}
		return list;
		
	}

	public ArrayList<Subject> profsub() {
		// TODO Auto-generated method stub
		ArrayList<Subject> list = new ArrayList<Subject>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Subject subject = null;
		try
		{
			conn = connect();
			pstmt = conn.prepareStatement("select * from Subject");
			rs = pstmt.executeQuery();
			if(rs.next()) 
			{
				subject = new Subject();
				subject.setId(rs.getString(1));
				subject.setName(rs.getString(2));
				subject.setCount(rs.getString(3));
				
				list.add(subject);
			}
		}catch(Exception e) {
			System.out.print("error"+e);
		}finally {
			close(conn,pstmt,rs);
		}
		return list;
	}

}
