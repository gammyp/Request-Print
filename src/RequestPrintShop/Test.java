/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintShop;


import RequestPrintDatabase.ConnectionBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class Test {

    public static void main(String args[]) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        StringTokenizer stk = new StringTokenizer(sdf.format(date), "-");
        
        ManageListBook book = new ManageListBook();
        book.setVisible(true);
        try {
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT date,detail FROM Product WHERE productID = ?");
            pstm.setInt(1, 1);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                System.out.println(rs.getDate("date").toString());
                book.showDate.setText(rs.getDate("date")+"");
//                book.showDetail.setText(rs.getString("detail"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageListBook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
