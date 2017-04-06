package RequestPrintDatabase;

import java.sql.*;
import java.util.logging.*;

public class ConnectionBuilder {

    public static Connection getConnection() throws SQLException {
        
        Connection con = DriverManager.getConnection("jdbc:mysql://korrow.sit.kmutt.ac.th:3306/mydb?zeroDateTimeBehavior=convertToNull", "mooza","123456789");
//        Connection con = null;
//        try {
//            String host = "jdbc:mysql://korrow.sit.kmutt.ac.th:3306/mydb?zeroDateTimeBehavior=convertToNull";
//            String userName = "mooza";
//            String userPass = "123456789";
//
//            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver loaded");
//
//            con = DriverManager.getConnection(host, userName, userPass);
//            System.out.println("Conncetion Created");
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ConnectionBuilder.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ConnectionBuilder.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return con;
        return con;
    }
}
