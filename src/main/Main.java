package main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import DepartmentMenu.DepartmentMenu;


public class Main 
{
	public static Connection conn;

	public static void main(String[] args) 
	{
		try {
		    //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/department", "ya", "euncZ23-");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/department_final?useSSL=false", "root", "euncZ23-");
		    if (conn != null) {
		    	//JOptionPane.showMessageDialog (null, "Succesful conection to database!" ); 
		    }
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
		
		DepartmentMenu frame = new DepartmentMenu();
		frame.setVisible(true);
	}
}
