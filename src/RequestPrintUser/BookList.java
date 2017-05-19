/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestPrintUser;

import RequestPrintDatabase.ConnectionBuilder;
import java.awt.Color;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author jirayupeach
 */
public class BookList extends javax.swing.JFrame {

    private int UserId;
    private String Username;
    private int shopID;
    private int productID;
    private int orderID;
    private static int LastOrderID;
    private static int LastShopID;

    public BookList() {
        initComponents();

    }


    public void setUserId(int UserId) {
        this.UserId = UserId;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }
    //Method for call from GUI
    
    public void callList() {
        ShopSelect.removeAllItems();
        BookSelect.removeAllItems();
        Copies.setValue(1);
        try {
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement pstm = con.prepareStatement("SELECT shopName FROM ShopProfile");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ShopSelect.addItem(rs.getString("shopName"));
            }
            con.close();
            pstm.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Connection con = ConnectionBuilder.getConnection();

            //executeQuery ShopProfile Table to use ShopID
            PreparedStatement pstmSelectShopId = con.prepareStatement("SELECT shopID FROM ShopProfile WHERE "
                    + "shopName = '" + ShopSelect.getSelectedItem() + "'");
            ResultSet rsShopId = pstmSelectShopId.executeQuery();
            if (rsShopId.next()) {
                shopID = rsShopId.getInt("shopID");
            }
            
            con.close();
            pstmSelectShopId.close();
            //executeQuery Product Table to use ProductName
            
            con = ConnectionBuilder.getConnection();
            PreparedStatement pstmSelectProduct = con.prepareStatement("SELECT productName,productID FROM Product WHERE ShopProfile_shopID = " + shopID);
            ResultSet rsProductName = pstmSelectProduct.executeQuery();
            if(rsProductName.next()){
                productID = rsProductName.getInt("productID");
            }
            
            //Add intitial text
            BookSelect.addItem("");
        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void callHome() {
        Home h = new Home();
        h.setUserId(UserId);
        h.setUsername(Username);
        h.setVisible(true);
        this.setVisible(false);
    }
    public void callUserProfile() {
        Userprofile userpro = new Userprofile();
        userpro.setUserId(UserId);
        userpro.setUsername(Username);
        userpro.setVisible(true);
        setVisible(false);
    }
    
    public void callRequestPage() {
        UserRequest userreq = new UserRequest();
        userreq.setUserId(UserId);
        userreq.setUsername(Username);
        userreq.setVisible(true);
        setVisible(false);
    }
    
    public void PrintBook() {
        BookSelect.removeAllItems();
        try {
            Connection con = ConnectionBuilder.getConnection();

            //executeQuery ShopProfile Table to use ShopID
            PreparedStatement pstmSelectShopId = con.prepareStatement("SELECT shopID FROM ShopProfile WHERE "
                    + "shopName = '" + ShopSelect.getSelectedItem() + "'");
            ResultSet rsShopId = pstmSelectShopId.executeQuery();
            if(rsShopId.next()){
                LastShopID = rsShopId.getInt("shopID");
            }
              

            //executeQuery Product Table to use ProductName
            PreparedStatement pstmSelectProduct = con.prepareStatement("SELECT productName FROM Product WHERE "
                    + "ShopProfile_shopID = "+ LastShopID);
            ResultSet rsProductName = pstmSelectProduct.executeQuery();

            //Add intitial text
            BookSelect.addItem("");
            while (rsProductName.next()) {
                BookSelect.addItem(rsProductName.getString("productName"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void Logout() {
        System.exit(0);
    }
    
    public void RequestBook() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date(System.currentTimeMillis());
            String datestr = sdf.format(date);
            Connection con = ConnectionBuilder.getConnection();
            
            PreparedStatement pstmInsert1 = con.prepareStatement("INSERT INTO Orders(orderID,priceOrder,status,datetime,description,url,UserProfile_id,ShopProfile_shopID)"
                    + "VALUES (null,?,?,?,?,null,?,?)");
            pstmInsert1.setInt(1, productID);
            if ((int) Copies.getValue() > 0) {
                pstmInsert1.setString(2, "Pending Responding");
            } else if ((int) Copies.getValue() > 100) {
                pstmInsert1.setString(2, "Pending Payment");
            }
            pstmInsert1.setString(3, datestr);
            pstmInsert1.setString(4, description.getText());
            pstmInsert1.setInt(5, UserId);
            pstmInsert1.setInt(6, shopID);
            pstmInsert1.executeUpdate();

            PreparedStatement pstmSel = con.prepareStatement("SELECT orderID FROM Orders WHERE orderID = ?");
            pstmSel.setInt(1, getOrderID());
            ResultSet rs = pstmSel.executeQuery();
            while (rs.next()) {
                orderID = rs.getInt("orderID");
            }

            PreparedStatement pstmInsert2 = con.prepareStatement("INSERT INTO SheetOrder(sheetID,productAmount,Order_orderID,Product_productID)"
                    + "VALUES(null,?,?,?)");
            pstmInsert2.setInt(1, (int) Copies.getValue());
            pstmInsert2.setInt(2, orderID);
            pstmInsert2.setInt(3, productID);
            pstmInsert2.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Success");
                    } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //End Method for call
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        YourProfileBox = new javax.swing.JPanel();
        YourProfile = new javax.swing.JLabel();
        RequestPrintBox = new javax.swing.JPanel();
        RequestPrint = new javax.swing.JLabel();
        HomeBox = new javax.swing.JPanel();
        Home = new javax.swing.JLabel();
        LogoutBox = new javax.swing.JPanel();
        Logout = new javax.swing.JLabel();
        BookListBox = new javax.swing.JPanel();
        BookList = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Copies = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        ShopSelect = new javax.swing.JComboBox<>();
        BookSelect = new javax.swing.JComboBox<>();
        Request = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(769, 750));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        YourProfileBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                YourProfileBoxMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                YourProfileBoxMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                YourProfileBoxMouseEntered(evt);
            }
        });

        YourProfile.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        YourProfile.setText("Your Profile");

        javax.swing.GroupLayout YourProfileBoxLayout = new javax.swing.GroupLayout(YourProfileBox);
        YourProfileBox.setLayout(YourProfileBoxLayout);
        YourProfileBoxLayout.setHorizontalGroup(
            YourProfileBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(YourProfileBoxLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(YourProfile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        YourProfileBoxLayout.setVerticalGroup(
            YourProfileBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, YourProfileBoxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(YourProfile)
                .addContainerGap())
        );

        RequestPrintBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RequestPrintBoxMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RequestPrintBoxMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RequestPrintBoxMouseEntered(evt);
            }
        });

        RequestPrint.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        RequestPrint.setText("Request to print");

        javax.swing.GroupLayout RequestPrintBoxLayout = new javax.swing.GroupLayout(RequestPrintBox);
        RequestPrintBox.setLayout(RequestPrintBoxLayout);
        RequestPrintBoxLayout.setHorizontalGroup(
            RequestPrintBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RequestPrintBoxLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(RequestPrint)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        RequestPrintBoxLayout.setVerticalGroup(
            RequestPrintBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RequestPrintBoxLayout.createSequentialGroup()
                .addComponent(RequestPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        HomeBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeBoxMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeBoxMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeBoxMouseEntered(evt);
            }
        });

        Home.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        Home.setText("Home");

        javax.swing.GroupLayout HomeBoxLayout = new javax.swing.GroupLayout(HomeBox);
        HomeBox.setLayout(HomeBoxLayout);
        HomeBoxLayout.setHorizontalGroup(
            HomeBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeBoxLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(Home)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomeBoxLayout.setVerticalGroup(
            HomeBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        LogoutBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutBoxMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                LogoutBoxMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LogoutBoxMouseEntered(evt);
            }
        });

        Logout.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        Logout.setText("Log out");

        javax.swing.GroupLayout LogoutBoxLayout = new javax.swing.GroupLayout(LogoutBox);
        LogoutBox.setLayout(LogoutBoxLayout);
        LogoutBoxLayout.setHorizontalGroup(
            LogoutBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutBoxLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(Logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        LogoutBoxLayout.setVerticalGroup(
            LogoutBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutBoxLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BookListBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookListBoxMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BookListBoxMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BookListBoxMouseEntered(evt);
            }
        });

        BookList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        BookList.setText("Book List");

        javax.swing.GroupLayout BookListBoxLayout = new javax.swing.GroupLayout(BookListBox);
        BookListBox.setLayout(BookListBoxLayout);
        BookListBoxLayout.setHorizontalGroup(
            BookListBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BookListBoxLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(BookList)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BookListBoxLayout.setVerticalGroup(
            BookListBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BookListBoxLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BookList)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RequestPrintBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomeBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LogoutBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(YourProfileBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BookListBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(HomeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(YourProfileBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(RequestPrintBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BookListBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LogoutBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel7.setText("Book List");

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel8.setText("Select Shop");

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel9.setText("Book List");

        jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel10.setText("Copies");

        Copies.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel11.setText("Message");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        ShopSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        ShopSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShopSelectActionPerformed(evt);
            }
        });

        BookSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        BookSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookSelectActionPerformed(evt);
            }
        });

        Request.setText("RequestPrint");
        Request.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(BookSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ShopSelect, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(Copies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(jLabel11))
                        .addGap(0, 87, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1)
                        .addGap(32, 32, 32)
                        .addComponent(Request)
                        .addGap(49, 49, 49))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(ShopSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BookSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Copies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Request)
                        .addGap(55, 55, 55))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        callList();
        BookList.setForeground(Color.white);
        BookListBox.setBackground(Color.black);

    }//GEN-LAST:event_formWindowActivated

    private void HomeBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBoxMouseClicked
        // TODO add your handling code here:
        callHome();
    }//GEN-LAST:event_HomeBoxMouseClicked

    private void HomeBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBoxMouseEntered
        // TODO add your handling code here:
        Home.setForeground(Color.WHITE);
        HomeBox.setBackground(Color.BLACK);
    }//GEN-LAST:event_HomeBoxMouseEntered

    private void HomeBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeBoxMouseExited
        // TODO add your handling code here:
        HomeBox.setBackground(null);
        Home.setForeground(Color.BLACK);
    }//GEN-LAST:event_HomeBoxMouseExited

    private void YourProfileBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileBoxMouseEntered
        // TODO add your handling code here:
        YourProfileBox.setBackground(Color.BLACK);
        YourProfile.setForeground(Color.WHITE);
    }//GEN-LAST:event_YourProfileBoxMouseEntered

    private void YourProfileBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileBoxMouseClicked
        // TODO add your handling code here:
        callUserProfile();
    }//GEN-LAST:event_YourProfileBoxMouseClicked

    private void YourProfileBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YourProfileBoxMouseExited
        // TODO add your handling code here:
        YourProfileBox.setBackground(null);
        YourProfile.setForeground(Color.BLACK);
    }//GEN-LAST:event_YourProfileBoxMouseExited

    private void RequestPrintBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestPrintBoxMouseClicked
        // TODO add your handling code here:
        callRequestPage();
    }//GEN-LAST:event_RequestPrintBoxMouseClicked

    private void RequestPrintBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestPrintBoxMouseEntered
        // TODO add your handling code here:
        RequestPrintBox.setBackground(Color.BLACK);
        RequestPrint.setForeground(Color.WHITE);
    }//GEN-LAST:event_RequestPrintBoxMouseEntered

    private void RequestPrintBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RequestPrintBoxMouseExited
        // TODO add your handling code here:
        RequestPrint.setForeground(Color.black);
        RequestPrintBox.setBackground(null);
    }//GEN-LAST:event_RequestPrintBoxMouseExited

    private void LogoutBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBoxMouseClicked
        // TODO add your handling code here:
        Logout();
    }//GEN-LAST:event_LogoutBoxMouseClicked

    private void LogoutBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBoxMouseEntered
        // TODO add your handling code here:
        Logout.setForeground(Color.white);
        LogoutBox.setBackground(Color.BLACK);
    }//GEN-LAST:event_LogoutBoxMouseEntered

    private void LogoutBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutBoxMouseExited
        // TODO add your handling code here:
        Logout.setForeground(Color.black);
        LogoutBox.setBackground(null);
    }//GEN-LAST:event_LogoutBoxMouseExited

    private void ShopSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShopSelectActionPerformed
        PrintBook();
    }//GEN-LAST:event_ShopSelectActionPerformed

    private void BookSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookSelectActionPerformed

    private void BookListBoxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListBoxMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_BookListBoxMouseEntered

    private void BookListBoxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListBoxMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BookListBoxMouseExited

    private void BookListBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookListBoxMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BookListBoxMouseClicked

    private void RequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RequestActionPerformed
        RequestBook();
    }//GEN-LAST:event_RequestActionPerformed

    public static int getOrderID(){
        try {
            Connection con = ConnectionBuilder.getConnection();
            PreparedStatement pstmSel = con.prepareStatement("SELECT orderID FROM Orders;");
            ResultSet rs = pstmSel.executeQuery();
            while(rs.next()){
                LastOrderID = rs.getInt("orderID");
            }
            
            System.out.println("LastOrderId"+LastOrderID);
        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        }
        return LastOrderID;
    }

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
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BookList;
    private javax.swing.JPanel BookListBox;
    private javax.swing.JComboBox<String> BookSelect;
    private javax.swing.JSpinner Copies;
    private javax.swing.JLabel Home;
    private javax.swing.JPanel HomeBox;
    private javax.swing.JLabel Logout;
    private javax.swing.JPanel LogoutBox;
    private javax.swing.JButton Request;
    private javax.swing.JLabel RequestPrint;
    private javax.swing.JPanel RequestPrintBox;
    private javax.swing.JComboBox<String> ShopSelect;
    private javax.swing.JLabel YourProfile;
    private javax.swing.JPanel YourProfileBox;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
