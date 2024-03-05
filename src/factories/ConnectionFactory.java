package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	private static String driver = "org.postgresql.Driver";
	private static String url = "jdbc:postgresql://localhost:5432/bd_exercicio04";
	private static String user = "postgres";
	private static String password = "admin";

	public static Connection getConnection() throws Exception {

		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, password);

		return connection;
	}
}
