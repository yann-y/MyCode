package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import filter.JdbcUtil;

import vo.Area;
import vo.City;
import vo.Province;

public class Addressdao implements IAddressdao{

	@Override
	public List<Province> getAllProvince() throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		List<Province> pro = new ArrayList<Province>();
		con=JdbcUtil.getConnection();
		String sql = "select * from pub_province";
		prepStmt=con.prepareStatement(sql);
		rs=prepStmt.executeQuery();
		while(rs.next()) {
			Province pro2=new Province();
			pro2.setName(rs.getString(2));
			pro2.setCode(rs.getString(3));
			pro2.setParent_code(rs.getString(4));
			pro.add(pro2);
		}
		JdbcUtil.free(con, prepStmt, rs);
		//System.out.println("yes!!!");
		return pro;
	}

	@Override
	public List<Province> getAllCity(String provCode) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		List<Province> pro = new ArrayList<Province>();
		con=JdbcUtil.getConnection();
		//String sql = "select * from pub_province where  name=?";
		String sql = "select * from pub_city where  parent_code=?";
		prepStmt=con.prepareStatement(sql);
		prepStmt.setString(1,provCode);
		rs=prepStmt.executeQuery();
		while(rs.next()) {
			Province pro2=new Province();
			pro2.setName(rs.getString(2));
			pro2.setCode(rs.getString(3));
			pro2.setParent_code(rs.getString(4));
			pro.add(pro2);
		}
		JdbcUtil.free(con, prepStmt, rs);
		//System.out.println("yes!!!");
		return pro;
	}

	@Override
	public List<Province> getAllArea(String provCode) throws Exception {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		List<Province> pro = new ArrayList<Province>();
		con=JdbcUtil.getConnection();
		//String sql = "select * from pub_province where  name=?";
		String sql = "select * from pub_area where  parent_code=?";
		prepStmt=con.prepareStatement(sql);
		prepStmt.setString(1,provCode);
		rs=prepStmt.executeQuery();
		while(rs.next()) {
			Province pro2=new Province();
			pro2.setName(rs.getString(2));
			pro2.setCode(rs.getString(3));
			pro2.setParent_code(rs.getString(4));
			pro.add(pro2);
		}
		JdbcUtil.free(con, prepStmt, rs);
		//System.out.println("yes!!!");
		return pro;
	}
	public String getProvcode(String provCode) throws Exception {
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		List<Province> pro = new ArrayList<Province>();
		con=JdbcUtil.getConnection();
		String sql = "select * from pub_province where  name=?";
		prepStmt=con.prepareStatement(sql);
		prepStmt.setString(1,provCode);
		rs=prepStmt.executeQuery();
		while(rs.next()) {
			provCode  = rs.getString(3);
		}
		JdbcUtil.free(con, prepStmt, rs);
		//System.out.println("yes!!!");
		return provCode;
	}
	public String getAreacode(String provCode) throws Exception {
		Connection con=null;
		PreparedStatement prepStmt=null;
		ResultSet rs=null;
		List<Province> pro = new ArrayList<Province>();
		con=JdbcUtil.getConnection();
		String sql = "select * from pub_city where  name=?";
		prepStmt=con.prepareStatement(sql);
		prepStmt.setString(1,provCode);
		rs=prepStmt.executeQuery();
		while(rs.next()) {
			provCode  = rs.getString(4);
		}
		JdbcUtil.free(con, prepStmt, rs);
		//System.out.println("yes!!!");
		return provCode;
	}
}
