package com.emp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.Model.admin;
import com.emp.Model.employee;


public class adminDao {
    public Connection connection() throws ClassNotFoundException, SQLException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/emp_tracker";
        String jdbcUser = "root";
        String jdbcPass = "Leave me alone 321@";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPass);
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        return con;
    }
    public List<employee> getAllCustomers(){
		List<employee> task=new ArrayList<>();
		try {
			Connection con = connection();
			PreparedStatement ps=con.prepareStatement("select * from task;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				employee t=new employee();
				t.setRole(rs.getString(1));
				t.setEmpid(rs.getString(2));
				t.setName(rs.getString(3));
				t.setDate(rs.getString(4));
				t.setMy_associate(rs.getString(5));
				t.setStart_time(rs.getString(6));
				t.setEnd_time(rs.getString(7));
				t.setTotal_time(rs.getString(8));
				
				task.add(t);
			}
			rs.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return task;
	}

    
    public ResultSet adminVerify(admin ad) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = connection();
            ps = con.prepareStatement("SELECT uname, pass FROM admin WHERE uname=? AND pass=?");
            ps.setString(1, ad.getUname());
            ps.setString(2, ad.getPass());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return rs;
    }
}
