package mysql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mainFunc {

	// private static TestConnection connection;

	public static void main(String[] args) throws Exception {
		Connection conn;
		Statement state = null;
		Long start = System.currentTimeMillis();
		mysqlTest connection = new mysqlTest();
		try {
			conn = connection.getConnection();
			state = conn.createStatement();
			// 需要使用100条sql语句来插入数据
//			for (int i = 0; i < 100; i++) {
//				int num = i;
//				String str2 = "name" + i;
//				state.executeUpdate("insert into tx1 values('" + num + "','str" + i + "')");
//			}
			
			//ResultSet res = state.executeQuery("SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_DEFAULT   FROM INFORMATION_SCHEMA.COLUMNS where table_schema = 'employees';");
			ResultSet res = state.executeQuery("SELECT * FROM employees.salaries;");
			System.out.println("使用Statement费时：" + (System.currentTimeMillis() - start));
			
			int rowCount = 0;
			while(res.next()) {
				rowCount++;
				System.out.println("res：" + res.getString("emp_no")+" ");
//				System.out.println("res：" + res.getString(2)+" ");
//				System.out.println("res：" + res.getString(3)+" ");
//				System.out.println("res：" + res.getString(4)+" ");
//				System.out.println("res：" + res.getString(5)+" ");
//				System.out.println("res：" + res.getString(6)+" ");
//				System.out.println("res：" + res.getString(7)+" ");
			}
			System.out.println("res：" + res.getRow());
			System.out.println("res：" + rowCount);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connection.closeConn();
			if (state != null) {
				try {
					state.close();
				}catch(SQLException es) {
					es.printStackTrace();
				}
				
			}
		}

	}
}