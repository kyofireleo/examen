package com.coppel.examen.repository.tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connector {
	private Connection con = null;

	public ResultSet spCall(String spName, String parameters) throws SQLException{
		connect();
		Statement stmt;
		ResultSet rs;

		if(con != null){
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String query = "EXEC Examen.dbo." + spName + " " + parameters;
			rs = stmt.executeQuery(query);
		}else{
			return null;
		}

		return rs;
	}

	private void connect(){
		String driver;
		String user;
		String pass;
		String dbUrl;
		
		try (InputStream input = new FileInputStream("C:/users/esque/Documents/examen/src/main/resources/application.properties")) {
			if(con != null && !con.isClosed())
				con.close();

			Properties prop = new Properties();

			prop.load(input);

			driver = prop.getProperty("jdbc.driver");
			dbUrl = prop.getProperty("jdbc.url");
			user = prop.getProperty("jdbc.username");
			pass = prop.getProperty("jdbc.password");
			
		   Class.forName(driver);
		   this.con = DriverManager.getConnection(dbUrl, user, pass);

		   if(con != null){
				System.out.println("Connected to Data Base...");
		   }else{
				System.out.println("Connection failed");
		   }

		} catch (IOException | ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}
}
