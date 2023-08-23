package homework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class db_connect {

	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Connection con = null;
		Statement statement = null;

		try {
			// データベースに接続
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost/java_janken",
					"root",
					"kCky6R22");
			System.out.println("データベース接続成功");

			statement = con.createStatement();
			
			String sql = """
					  CREATE TABLE result (
					            id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
					            myself VARCHAR(10) NOT NULL,
					            pc VARCHAR(10) NOT NULL,
					            result VARCHAR(10) NOT NULL,
					            
					          );

					""";
			int rowCnt = statement.executeUpdate(sql);
			System.out.println("テーブルを作成:rowCnt=" + rowCnt);
			
		} catch (SQLException e) {
			System.out.println("エラー発生：" + e.getMessage());
		} finally {
			// 使用したオブジェクトを解放
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException ignore) {
				}
			}
		}

	}

}

