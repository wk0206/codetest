package mysql;

import java.sql.Connection;
import java.sql.*;

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
			
			state.executeQuery("SELECT COLUMN_NAME, DATA_TYPE, IS_NULLABLE, COLUMN_DEFAULT   FROM INFORMATION_SCHEMA.COLUMNS where table_schema = 'employees';");
			System.out.println("使用Statement费时：" + (System.currentTimeMillis() - start));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			connection.closeConn();
			if (state != null) {
				state.close();
			}
		}

	}
}