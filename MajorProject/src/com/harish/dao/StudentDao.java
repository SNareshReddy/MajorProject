package com.harish.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.harish.beans.StudentBean;

public class StudentDao {
	public static int save(StudentBean bean){
		int status=0;
	try{
		Connection con=DB.getCon();
		PreparedStatement ps=con.prepareStatement("insert into student(id, sname, sfname, smname, address, mobile, wnumber, fmobile,mmobile, email, password,aadhar,cgpa,category,branch,section) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setInt(1,bean.getId());
		ps.setString(2,bean.getName());
		ps.setString(3,bean.getSfname());
		ps.setString(4,bean.getSmname());
		ps.setString(5, bean.getAddress());
		ps.setLong(6,bean.getMobile());
		ps.setLong(7,bean.getWnumber());
		ps.setLong(8,bean.getFmobile()); 
		ps.setLong(9,bean.getMmobile());
		ps.setString(10,bean.getEmail());
		ps.setString(11,bean.getPassword());
		ps.setString(12,bean.getAadhar());
		ps.setString(13,bean.getCgpa());
		ps.setString(14,bean.getCategory());
		ps.setString(15, bean.getBranch());
		ps.setString(16,bean.getSection());
		
		status=ps.executeUpdate();
		con.close();
		
	}catch(Exception e){System.out.println(e);}
	

	return status;
}

	public static boolean authenticate(String email,String password){
		boolean status=false;
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from STUDENT where email=? and password=?");
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

		public static List<StudentBean> view() {
		List<StudentBean> list=new ArrayList<StudentBean>();
		try{
			Connection con=DB.getCon();
			PreparedStatement ps=con.prepareStatement("select * from STUDENT");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				StudentBean bean=new StudentBean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("sname"));
				bean.setSfname(rs.getString("sfname"));
				bean.setSmname(rs.getString("smname"));
				bean.setAddress(rs.getString("address"));
				bean.setMobile(rs.getLong("mobile"));
				bean.setWnumber(rs.getLong("wnumber"));
				bean.setFmobile(rs.getLong("fmobile"));
				bean.setMmobile(rs.getLong("mmobile"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setAadhar(rs.getString("aadhar"));
				bean.setCgpa(rs.getString("cgpa"));
				bean.setCategory(rs.getString("category"));
				bean.setBranch(rs.getString("branch"));
				bean.setSection(rs.getString("section"));
				list.add(bean);
			}
			con.close();
		}
		catch(Exception e){System.out.println(e);}
		return list;
	}
	
}



