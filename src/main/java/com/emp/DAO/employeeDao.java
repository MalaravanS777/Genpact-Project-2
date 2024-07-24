package com.emp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.Model.associate;
import com.emp.Model.employee;


public class employeeDao {
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
    public List<employee> getAllCustomers(employee emp){
		List<employee> task=new ArrayList<>();
		try {
			Connection con = connection();
			PreparedStatement ps=con.prepareStatement("select * from task where empid=? or my_associate=?;");
			ps.setString(1, emp.getUname());
			ps.setString(2, emp.getUname());
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
    
    public int addTask(employee emp) throws ClassNotFoundException,SQLException{
    	int rs=0;
    	Connection con=null;
    	PreparedStatement ps=null;
    	
    	 try {
             con = connection();
             ps = con.prepareStatement("Insert into task values(?,?,?,?,?,?,?,?,?);");
             ps.setString(1, emp.getRole());
             ps.setString(2, emp.getEmpid());
             ps.setString(3, emp.getName());
             ps.setString(4, emp.getDate());
             ps.setString(5, emp.getMy_associate());
             ps.setString(6, emp.getStart_time());
             ps.setString(7, emp.getEnd_time());
             ps.setString(8, emp.getTotal_time());
             ps.setString(9,emp.getTask());
             rs = ps.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         } 
         
         return rs;
    }
    
    public ResultSet assoVerify(employee emp) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            con = connection();
            ps = con.prepareStatement("SELECT * FROM employee WHERE uname=? AND pass=?;");
            ps.setString(1, emp.getUname());
            ps.setInt(2, emp.getPass());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        return rs;
    }
}
