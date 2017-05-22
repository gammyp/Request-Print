/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintUser;

import RequestPrintDatabase.ConnectionBuilder;
import RequestPrintLogin.LoginEPrinting;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Game
 */
public class SelectShop2 extends javax.swing.JFrame {

    private String Username;
    private int UserId;
    private String Link;
    private int DocCopies;
    private int ShopId;
    private String Message;
    //private int OrderID;

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public void setDocCopies(int DocCopies) {
        this.DocCopies = DocCopies;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void fetchShopList() {
        try {
            // TODO add your handling code here:
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT shopName FROM ShopProfile");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ShopList.addItem(rs.getString("shopName"));
            }

            con.close();
            pstm.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Back() {
        UserRequest usrreq = new UserRequest();
        usrreq.setUserId(UserId);
        usrreq.setUsername(Username);
        Link = "";
        Message = "";
        setVisible(false);
    }

    public void RequestBook() {
        try {
            int orderId = -1;
            int productID = -5;
            int shopID = -1;
            // TODO add your handling code here:
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            //System.out.println(sdf.format(date));
            String datestr = sdf.format(date);
            LoginEPrinting login = new LoginEPrinting();
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement pstmShopId = con.prepareStatement("SELECT shopID FROM ShopProfile WHERE shopName = '" + ShopList.getSelectedItem().toString() + "'");
            ResultSet rs = pstmShopId.executeQuery();
            while (rs.next()) {
                shopID = rs.getInt("shopID");
            }
            PreparedStatement pstm = con.prepareStatement("INSERT INTO Orders VALUES (null,?,?,?,?,?,?,?)");
            pstm.setInt(1, DocCopies);
            if (DocCopies > 0) {
                pstm.setString(2, "Pending Responding");
            } else if (DocCopies > 100) {
                pstm.setString(2, "Pending Payment");
            }
            pstm.setString(3, datestr);
            pstm.setString(4, Message);
            pstm.setString(5, Link);
            pstm.setInt(6, UserId);
            pstm.setInt(7, shopID);
            pstm.executeUpdate();
            //SELECT ProductID
            PreparedStatement pstm2 = con.prepareStatement("SELECT productID FROM Product WHERE ShopProfile_shopID = " + shopID);
            ResultSet rs2 = pstm2.executeQuery();
            while (rs2.next()) {
                productID = rs2.getInt("productID");
            }

            //SELECT OrderID
            PreparedStatement pstm3 = con.prepareStatement("SELECT MAX(orderID) FROM Orders");
            ResultSet rstest = pstm3.executeQuery();
            while (rstest.next()) {
                orderId = rstest.getInt("MAX(orderID)");
            }
            //INSERT SheetOrder
            PreparedStatement pstm4 = con.prepareStatement("INSERT INTO SheetOrder (productAmount, Order_orderID, Product_productID) VALUES (?, ?, ?)");
            pstm4.setInt(1, DocCopies);
            pstm4.setInt(2, orderId);
            pstm4.setInt(3, productID);
            pstm4.executeUpdate();
            con.close();
            pstm.close();
            pstm2.close();
            pstm3.close();
            pstm4.close();
            JOptionPane.showMessageDialog(null, "Thank you for chosing our shop.");
            Back();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }

    /**
     * Creates new form SelectShop2
     */
    public SelectShop2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ShopList = new javax.swing.JComboBox<>();
        CancelBox = new javax.swing.JPanel();
        Cancel = new javax.swing.JLabel();
        RequestBox = new javax.swing.JPanel();
        Request = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Moon", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Select Shop to Request.");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(2, 13, 480, 29);

        ShopList.setFont(new java.awt.Font("Cloud Light", 0, 14)); // NOI18N
        getContentPane().add(ShopList);
        ShopList.setBounds(30, 60, 400, 30);

        CancelBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelBoxMouseClicked(evt);
            }
        });
        CancelBox.setLayout(null);

        Cancel.setFont(new java.awt.Font("Cloud Light", 0, 18)); // NOI18N
        Cancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Cancel.setText("Cancel");
        Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CancelBox.add(Cancel);
        Cancel.setBounds(0, 0, 190, 40);

        getContentPane().add(CancelBox);
        CancelBox.setBounds(30, 110, 190, 40);

        RequestBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RequestBoxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RequestBoxMouseEntered(evt);
            }
        });
        RequestBox.setLayout(null);

        Request.setFont(new java.awt.Font("Cloud Light", 0, 18)); // NOI18N
        Request.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Request.setText("Request");
        Request.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RequestBox.add(Request);
        Request.setBounds(0, 0, 190, 40);

        getContentPane().add(RequestBox);
        RequestBox.setBounds(240, 110, 190, 40);

        setSize(new java.awt.Dimension(465, 209));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        fetchShopList();
        getContentPane().setBackground(new java.awt.Color(228, 228, 228));
        RequestBox.setBackground(new java.awt.Color(152, 255, 153));
        Request.setForeground(Color.black);
        CancelBox.setBackground(new java.awt.Color(255, 204, 204));
        Cancel.setForeground(Color.black);
    }//GEN-LAST:event_formWindowActivated

    private void RequestBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestBoxMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_RequestBoxMouseEntered

    private void RequestBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestBoxMouseClicked
        // TODO add your handling code here:
        RequestBook();
    }//GEN-LAST:event_RequestBoxMouseClicked

    private void CancelBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelBoxMouseClicked
        Back();
    }//GEN-LAST:event_CancelBoxMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SelectShop2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelectShop2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelectShop2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelectShop2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SelectShop2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancel;
    private javax.swing.JPanel CancelBox;
    private javax.swing.JLabel Request;
    private javax.swing.JPanel RequestBox;
    private javax.swing.JComboBox<String> ShopList;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
