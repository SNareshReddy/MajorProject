package com.harish.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.harish.beans.CounsellorBean;
import com.harish.dao.DB;

public class CounsellorDao {
	public static int save(CounsellorBean bean){
		int status=0;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("insert into counsellor(c_id,name,email,password,mobile) values(?,?,?,?,?)");
			ps.setInt(1,bean.getId());
			ps.setString(2,bean.getName());
			ps.setString(3,bean.getEmail());
			ps.setString(4,bean.getPassword());
			ps.setLong(5,bean.getMobile());
			status=ps.executeUpdate();
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from counsellor where email=? and password=?");
			ps.setString(1,email);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				status=true;
			}
			con.close();
			
		}catch(Exception e){System.out.println(e);}
		
		return status;
	}

	public static List<CounsellorBean> view() {
		List<CounsellorBean> list=new ArrayList<CounsellorBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from COUNSELLOR");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				CounsellorBean bean=new CounsellorBean();
				bean.setId(rs.getInt("c_id"));
				bean.setName(rs.getString("name"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setMobile(rs.getLong("mobile"));
				list.add(bean);
			}
			con.close();
		}
		catch(Exception e){System.out.println(e);}
		return list;
	}



public static CounsellorBean viewById(int id){
	CounsellorBean bean=new CounsellorBean();
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("select * from COUNSELLOR where c_id=?");
		
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setPassword(rs.getString(3));
			bean.setEmail(rs.getString(4));
			bean.setMobile(rs.getLong(5));
		}
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	
	return bean;
}

public static int update(CounsellorBean bean){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("update COUNSELLOR set name=?,email=?,password=?,mobile=? where c_id=?");
		ps.setString(1,bean.getName());
		ps.setString(2,bean.getEmail());
		ps.setString(3,bean.getPassword());
		ps.setLong(4,bean.getMobile());
		ps.setInt(5,bean.getId());
		status=ps.executeUpdate();
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	
	return status;
}

public static int delete(int id){
	int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("delete from COUNSELLOR where c_id=?");
		ps.setInt(1,id);
		status=ps.executeUpdate();
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	
	return status;
}
}
	
	