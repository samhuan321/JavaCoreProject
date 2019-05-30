package ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=hotelms;user=phong;password=1";
    private static Connection con = null;

    public static boolean open() {
        try {
            Class.forName(JDBC_DRIVER);
            con = DriverManager.getConnection(DB_URL);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static Connection getConnection() {
        if (con == null) {
            open();
        }
        return con;
    }

    public static void close() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("SQL Error:" + e.getMessage());
            }
        }
    }

    public static void testDB() {
        Connection con = DBConnection.getConnection();
        if (con != null) {
            System.out.println("Welcome to Database");
        } else {
            System.out.println("Connect FAILED");
        }
    }

    public static void main(String[] args) {
        testDB();
    }
}
