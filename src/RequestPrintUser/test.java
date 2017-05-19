/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintUser;

import RequestPrintDatabase.ConnectionBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            PreparedStatement pstm = con.prepareStatement("SELECT orderID FROM mydb.Order ORDER BY orderID DESC LIMIT 0,1");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt("orderID"));
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
}
