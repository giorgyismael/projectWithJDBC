package singleconnections;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnectionsJDBC {
	
	private static final String driver = "org.postgresql.Driver";
	private static final String banco = "myproject";
	private static final String user = "postgres";
	private static final String password = "postgres";
	private static final String url = "jdbc:postgresql://localhost:5432/"+ banco;
	private static Connection connection = null;

	static {
		connect();
	}

	public SingleConnectionsJDBC() {
		connect();
	}

	public static void connect() {

		if (connection == null) {

			try {
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		SingleConnectionsJDBC.connection = connection;
	}
}
