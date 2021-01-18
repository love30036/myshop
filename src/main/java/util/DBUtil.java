package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static final String url = "jdbc:mysql://localhost:3306/myshop?useSSL=false";
    public static final String user = "root";
    public static final String password = "131234";
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection =DriverManager.getConnection(url,user,password);
            System.out.println("db open");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection){
        try {
            connection.close();
            System.out.println("db close");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
