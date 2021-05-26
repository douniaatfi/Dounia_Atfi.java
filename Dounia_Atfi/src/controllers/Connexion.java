package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	protected static Connection con;
	 protected static Statement stm;
	 
	 public static void connect() throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.jdbc.Driver");
		 String url="jdbc:mysql://localhost:3306/dounia_atfi?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		 con=DriverManager.getConnection(url,"root","");
		 stm=con.createStatement();
	 }
	 
	 public static void disconnect() throws SQLException {
		 stm.close();
		 con.close();
	 }
	 public static int Maj(String sql) throws SQLException {
		 return stm.executeUpdate(sql);
	 }
	 public static ResultSet select(String sql) throws SQLException {
		 return stm.executeQuery(sql);
	 }
}
