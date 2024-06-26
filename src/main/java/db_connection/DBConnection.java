package Db_Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class DBConnection {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sunset_paradise_hotel";
    private static final String USERNAME = "Bahy Imane";
    private static final String PASSWORD = "kalamar";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Failed to connect to the database: " + e.getMessage());
        }
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
