package com.Ninza.Hrm.api.DataBase_Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DataBase_Utility {
	Connection con;

	public void getConnection() throws Exception {
		Driver ref = new Driver();
		DriverManager.registerDriver(ref);
		con = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/ninza_hrm", "root@%", "root");
		

	}
	public String executeQuery(String query) throws Exception {
		ResultSet result = con.createStatement().executeQuery(query);
		String data = null;
		while (result.next()) {
			data = result.getString(4);
		}
		return data;
		
	}
	public void closeConnection() throws Exception {
		con.close();
	}
	public static void main(String[] args) throws Exception {
		DataBase_Utility db = new DataBase_Utility();
		db.getConnection();
		String data = db.executeQuery("select * from project");
		System.out.println(data);
		db.closeConnection();
		
	}

}
