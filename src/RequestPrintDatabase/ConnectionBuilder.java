package RequestPrintDatabase;

import java.sql.*;
import java.util.logging.*;

public class ConnectionBuilder {

    public static Connection getConnection() {
        Connection con = null;
        try {
            String host = "jdbc:mysql://localhost:3306/RequestPrint";
            String userName = "RequestPrint";
            String userPass = "requestprint";

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Driver loaded");

            con = DriverManager.getConnection(host, userName, userPass);
            System.out.println("Conncetion Created");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void main(String[] args) {
        Connection con = ConnectionBuilder.getConnection();

    }
}
