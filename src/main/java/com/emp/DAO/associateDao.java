package com.emp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.Model.associate;

public class associateDao {
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
    public List<associate> getAllCustomers(associate asso){
		List<associate> task=new ArrayList<>();
		try {
			Connection con = connection();
			PreparedStatement ps=con.prepareStatement("select role,emp_id,name,date,start_time,end_time,total_time,task from task where empid=? or my_associate=?;");
			ps.setString(1, asso.getEmpid());
			ps.setString(2, asso.getEmpid());
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				associate t=new associate();
				t.setRole(rs.getString(1));
				t.setEmpid(rs.getString(2));
				t.setName(rs.getString(3));
				t.setDate(rs.getString(4));
				t.setStart_time(rs.getString(5));
				t.setEnd_time(rs.getString(6));
				t.setTotal_time(rs.getString(7));
				t.setTask(rs.getString(8));
				
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
    
  

    
    public ResultSet assoVerify(associate asso) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = connection();
            ps = con.prepareStatement("SELECT * FROM associate WHERE emp_id=? AND pass=?;");
            ps.setString(1, asso.getUname());
            ps.setInt(2, asso.getPass());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return rs;
    }
}
