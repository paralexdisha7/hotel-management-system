package hms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
	
	Statement s;
	Conn(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","miniproject","miniproject");
			s=con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
