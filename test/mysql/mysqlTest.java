package mysql;

import java.sql.Connection;
import java.sql.*;

public class mysqlTest {
	private String driver;
	private String url;
	private String dbName;
	private String password;
	Connection conn;
	Statement sta;
	PreparedStatement prepare;

	public mysqlTest() {
		this.driver = "com.mysql.jdbc.Driver";
		this.url = "jdbc:mysql://localhost:3306/employees";
		this.dbName = "root";
		this.password = "123";
	}

	public Connection getConnection() throws Exception {
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(url, dbName, password);
//			
		try {
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/employees?" +
		                                   "user=root&password=123&useSSL=false");
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;
	}
	
	public void closeConn()
    {
        try {
            if(this.conn!=null)
            {
                this.conn.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}


