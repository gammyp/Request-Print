/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintUser;

import RequestPrintDatabase.ConnectionBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Game
 */
public class test {
    public static void main(String[] args) {
        Connection con;
        try {
            con = ConnectionBuilder.getConnection();
            PreparedStatement pstm = con.prepareStatement("INSERT INTO mydb.Order VALUES (null,?,?,?,?,?,?,?)");
            pstm.setInt(1, 1);
            pstm.setString(2, "Pending Responding");
            pstm.setString(3, "hsadkl");
            pstm.setString(4, "hsadkl");
            pstm.setString(5, "hsadkl");
            pstm.setInt(6, 1);
            pstm.setInt(7, 3);
            pstm.executeUpdate();
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
}
