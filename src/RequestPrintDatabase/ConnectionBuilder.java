package RequestPrintDatabase;

import java.sql.*;
import java.util.logging.*;

public class ConnectionBuilder {

    public static Connection getConnection() throws SQLException {

        Connection con = null;
        try {
            String host = "jdbc:mysql://korrow.sit.kmutt.ac.th:3306/mydb?zeroDateTimeBehavior=convertToNull";
            String userName = "mooza";
            String userPass = "123456789";

            Class.forName("com.mysql.jdbc.Driver");
            //System.out.println("Driver loaded");

            con = DriverManager.getConnection(host, userName, userPass);
            //System.out.println("Conncetion Created");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) throws SQLException {
        Connection con = ConnectionBuilder.getConnection();

    }
}
